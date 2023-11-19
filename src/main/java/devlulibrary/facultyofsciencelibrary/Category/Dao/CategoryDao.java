package devlulibrary.facultyofsciencelibrary.Category.Dao;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    private List<CategoryModel> categoryList = new ArrayList<>();
    public CategoryDao() {
        categoryList.add(new CategoryModel("Math"));
    }
    public List<CategoryModel> getCategoryList() {
        return categoryList;
    }
    public CategoryModel getCategoryId(String id) {
        return categoryList.stream()
                .filter(categoryModel -> categoryModel.getCategory().equals(id))
                .findFirst()
                .orElse(null); // Return null if no matching category is found
    }
    public void addCategory(CategoryModel category) {
        categoryList.stream().filter(t -> t.getCategory().equals(category.getCategory())).findFirst().ifPresentOrElse(t -> {
            throw new IllegalStateException("Category already exist");
        }, () -> {
            categoryList.add(category);
        });
    }
    public void deleteCategory(String id) {
        categoryList.stream().filter(t -> t.getCategory().equals(id)).findFirst().ifPresentOrElse(t -> {
            categoryList.remove(t);
        }, () -> {
            throw new IllegalStateException("Category does not exist");
        });
    }

    public void updateCategory(String id, CategoryModel category) {
        categoryList.stream().filter(t -> t.getCategory().equals(id)).findFirst().ifPresentOrElse(t -> {
            categoryList.set(categoryList.indexOf(t),category);
        }, () -> {
            throw new IllegalStateException("category does not exist");
        });
    }
}
