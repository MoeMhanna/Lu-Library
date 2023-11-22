package devlulibrary.facultyofsciencelibrary.Books.Services;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BookForCreationDto;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Dao.CategoryDao;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Service.CategoryService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class BooksService {
    @Autowired
    private BooksDao booksDao;
    @Autowired
    private CategoryDao categoryDao;
    private Boolean checkCategoryValidation(CategoryModel categoryModel) {
        try{
            CategoryModel check=categoryDao.getCategoryId(categoryModel.getCategory());
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public ResponseEntity<List<BooksForResponseDto>> findAllBooks() {
        List<BooksModel> booksModelList = booksDao.getAllBook();
        if (booksModelList.isEmpty()) {
            ResponseEntity.notFound().build();
        }

        List<BooksForResponseDto> booksForResponseDtoList = new ArrayList<BooksForResponseDto>();
        for (BooksModel bookModel : booksModelList) {
            booksForResponseDtoList.add(new BooksForResponseDto(bookModel.getId(), bookModel.getBookName(), bookModel.getWriter(), bookModel.getDescription(), bookModel.getCategory()));
        }
        return ResponseEntity.ok(booksForResponseDtoList);
    }

    public ResponseEntity<BooksForResponseDto> getBookById(String id) {
        try {
            BooksModel bookModel = booksDao.getBookById(id);
            BooksForResponseDto booksForResponseDtoList = new BooksForResponseDto(bookModel.getId(), bookModel.getBookName(), bookModel.getWriter(), bookModel.getDescription(), bookModel.getCategory());
            return ResponseEntity.ok(booksForResponseDtoList);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Resource> downloadFile(String id) {
        try {
            BooksModel book = booksDao.getBookById(id);
            String bookName = book.getBookName();
            byte[] fileData = book.getFileData();
            return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/pdf")).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + bookName + "\"").body(new ByteArrayResource(fileData));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<BooksModel> uploadBook(BookForCreationDto book) {
        if (!checkCategoryValidation(book.getCategory())) {
            return ResponseEntity.badRequest().build();
        }
        if (book.getFile() == null) {
            return ResponseEntity.badRequest().build();
        }
        MultipartFile file = book.getFile();
        BooksModel bookModel = new BooksModel();
        try {
            bookModel.setBookName(file.getOriginalFilename());
            bookModel.setFileData(file.getBytes());
            bookModel.setWriter(book.getWriter());
            bookModel.setDescription(book.getDescription());
            bookModel.setCategory(book.getCategory());
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(booksDao.storeFile(bookModel));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(bookModel);
        }
    }
}
