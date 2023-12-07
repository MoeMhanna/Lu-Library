package devlulibrary.facultyofsciencelibrary.Category.Dao;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Repositories.CategoryRepositories;
import org.springframework.stereotype.Service;

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
        return this.categoryRepositories.findCategoryByCategoryName(category).orElseThrow(() -> new IllegalStateException("Category does not exist"));
    }

    public CategoryModel updateCategory(CategoryModel category) {
        return this.categoryRepositories.save(category);
    }

    public CategoryModel addCategory(CategoryModel category) {
        boolean exist = categoryRepositories.findCategoryByCategoryName(category.getCategoryName()).isPresent();
        if (exist) {
            throw new IllegalStateException();
        }
        return categoryRepositories.save(category);
    }

    public void deleteCategory(String category) {
        if (categoryRepositories.findCategoryByCategoryName(category).isEmpty()) {
            throw new IllegalStateException();
        }
        categoryRepositories.deleteCategoryByCategoryName(category);
    }
}
