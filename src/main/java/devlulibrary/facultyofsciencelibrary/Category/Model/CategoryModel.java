package devlulibrary.facultyofsciencelibrary.Category.Model;

import java.util.UUID;

public class CategoryModel {
    private String category;
    private String id;
    public CategoryModel(String category) {
        id = UUID.randomUUID().toString();
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
