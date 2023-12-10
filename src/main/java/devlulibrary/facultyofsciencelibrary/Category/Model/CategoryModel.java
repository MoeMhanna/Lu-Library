package devlulibrary.facultyofsciencelibrary.Category.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CategoryModel {
    private String categoryName;
    private int booksNumber;
    private int downloadNumber;

    public CategoryModel(String category, int booksNumber, int downloadNumber) {
        this.categoryName = category;
        this.booksNumber = booksNumber;
        this.downloadNumber = downloadNumber;
    }

    public CategoryModel() {
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

    public int getDownloadNumber() {
        return downloadNumber;
    }

    public void setDownloadNumber(int downloadNumber) {
        this.downloadNumber = downloadNumber;
    }
}
