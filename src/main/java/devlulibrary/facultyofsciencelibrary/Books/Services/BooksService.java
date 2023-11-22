package devlulibrary.facultyofsciencelibrary.Books.Services;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BookForCreationDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Component
public class BooksService {
    private Boolean checkCategoryValidation(String categoryModel) {
        //to be added later
        return true;
    }

    @Autowired
    private BooksDao booksDao;

    public ResponseEntity<BooksModel> uploadBook(BookForCreationDto book) {
        if (!checkCategoryValidation(book.getBookName())) {
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
