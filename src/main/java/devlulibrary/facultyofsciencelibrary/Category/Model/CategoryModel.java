package devlulibrary.facultyofsciencelibrary.Category.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CategoryModel {
    private String categoryName;
    private int booksNumber;

    public CategoryModel() {
    }

    public CategoryModel(String category, int booksNumber) {
        this.categoryName = category;
        this.booksNumber=booksNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getBooksNumber() {
        return booksNumber;
    }

    public void setBooksNumber(int booksNumber) {
        this.booksNumber = booksNumber;
    }
}
