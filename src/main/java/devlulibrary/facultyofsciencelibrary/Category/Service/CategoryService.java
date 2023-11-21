package devlulibrary.facultyofsciencelibrary.Category.Service;

import devlulibrary.facultyofsciencelibrary.Category.Dao.CategoryDao;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class CategoryService {
    private final CategoryDao categoryDao;
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
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
            return ResponseEntity.noContent().build();
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
