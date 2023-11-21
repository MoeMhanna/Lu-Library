package devlulibrary.facultyofsciencelibrary.Category.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CategoryModel {
    private String category;
    public CategoryModel(){}
    public CategoryModel(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
