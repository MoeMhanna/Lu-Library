package devlulibrary.facultyofsciencelibrary.Category.Model;

import java.util.UUID;

public class CategoryModel {
    private String category;
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
