package devlulibrary.facultyofsciencelibrary.Category.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CategoryModel {
    private String categoryName;

    public CategoryModel() {
    }

    public CategoryModel(String category) {
        this.categoryName = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
