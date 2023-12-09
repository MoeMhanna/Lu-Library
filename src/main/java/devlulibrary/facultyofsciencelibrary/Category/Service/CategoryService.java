package devlulibrary.facultyofsciencelibrary.Category.Service;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Dao.CategoryDao;
import devlulibrary.facultyofsciencelibrary.Category.Dto.CategoryForCreationDto;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    public BooksDao booksDao;
    private List<BooksModel> getBookListFromCategory (String categoryName){
        /* Java streams to process the collection of books obtained from booksDao.
        It filters the books based on a specified categoryName using a lambda expression
        within the filter operation and then collects the filtered results into a List using the toList() method. */
        return booksDao.getAllBook().stream()
                .filter(book -> book.getCategory().getCategoryName().equals(categoryName))
                .toList();
    }
    public ResponseEntity<List<BooksForResponseDto>> getCategoryBooks(String categoryName){
        List<BooksModel> booksModelList= getBookListFromCategory(categoryName);
                List<BooksForResponseDto> booksForResponseDtoList = new ArrayList<BooksForResponseDto>();
        for (BooksModel bookModel : booksModelList) {
            booksForResponseDtoList.add(new BooksForResponseDto(bookModel.getId(), bookModel.getBookName(), bookModel.getWriter(), bookModel.getDescription(), bookModel.getCategory()));
        }
        return ResponseEntity.ok(booksForResponseDtoList);
    }
    public ResponseEntity<List<CategoryModel>> getCategoryList() {
        return ResponseEntity.ok(categoryDao.getCategoryList());
    }
    public ResponseEntity<CategoryModel> getCategoryById(String category) {
        try {
            return ResponseEntity.ok(categoryDao.getCategoryId(category));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<CategoryModel> addCategory(CategoryForCreationDto categoryForCreationDto) {
        try {
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(categoryDao.addCategory(new CategoryModel(categoryForCreationDto.getCategoryName(),0, 0)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
    }
    public ResponseEntity deleteCategory(String categoryName) {
        try {
            categoryDao.deleteCategory(categoryName);
            List<BooksModel> booksModelList= getBookListFromCategory(categoryName);
            for (BooksModel book: booksModelList) {
                 booksDao.deleteBookById(book.getId());
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
