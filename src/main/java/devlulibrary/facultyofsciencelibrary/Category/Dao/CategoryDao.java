package devlulibrary.facultyofsciencelibrary.Category.Dao;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Repositories.CategoryRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryDao {
    private final CategoryRepositories categoryRepositories;

    public CategoryDao(CategoryRepositories categoryRepositories) {
        this.categoryRepositories = categoryRepositories;
    }
    public List<CategoryModel> getCategoryList() {
        return categoryRepositories.findAll();
    }
    public CategoryModel getCategoryId(String category) {
        return this.categoryRepositories.findCategoryModelByCategory(category).orElseThrow(() -> new IllegalStateException("Category does not exist"));
    }
    public void addCategory(CategoryModel category) {
        if(!categoryRepositories.findCategoryModelByCategory(category.getCategory()).isPresent()){
            categoryRepositories.save(category);
        }
        else{throw new IllegalStateException();}
    }
    public void deleteCategory(String category) {
        if(categoryRepositories.findCategoryModelByCategory(category).isPresent()){
             categoryRepositories.deleteCategoryModelByCategory(category);
        }
        else{
            throw new IllegalStateException();
        }
    }
}
