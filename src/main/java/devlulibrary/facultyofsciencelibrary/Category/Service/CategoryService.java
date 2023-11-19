package devlulibrary.facultyofsciencelibrary.Category.Service;

import devlulibrary.facultyofsciencelibrary.Category.Dao.CategoryDao;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class CategoryService {
    private final CategoryDao categoryDao=new CategoryDao();
    public List<CategoryModel> getCategoryList() {
        return categoryDao.getCategoryList();
    }
    public CategoryModel getCategoryById(String id) {
        try {
            return categoryDao.getCategoryId(id);
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalStateException("Category does not exist");
        }
    }
    public void addCategory(CategoryModel category)
    {
        //check if book.category exists using category dao and throw exception
        categoryDao.addCategory(category);
    }
    public void deleteCategory(String id) {
        categoryDao.deleteCategory(id);
    }
}
