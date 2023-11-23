package devlulibrary.facultyofsciencelibrary.Category.Service;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Dao.CategoryDao;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    public BooksDao booksDao;
    public ResponseEntity<List<BooksForResponseDto>> getCategoryBooks(String category){
        List<BooksModel> booksModelList= booksDao.getAllBook().stream()
                    .filter(book -> book.getCategory().getCategory().equals(category))
                    .collect(Collectors.toList());
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
    public ResponseEntity<CategoryModel> addCategory(CategoryModel category)
    {
        try {
            categoryDao.addCategory(category);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
    }
    public ResponseEntity deleteCategory(String category) {
        try {
            categoryDao.deleteCategory(category);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
