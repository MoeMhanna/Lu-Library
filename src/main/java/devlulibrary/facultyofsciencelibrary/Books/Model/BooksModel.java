package devlulibrary.facultyofsciencelibrary.Books.Model;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class BooksModel {
    @Id
    private String id;
    private String bookName;
    private byte[] fileData;
    private String writer;
    private String description;
    private CategoryModel category;

    public BooksModel() {
    }

    public BooksModel(String bookName, String writer, String description, CategoryModel category) {
        id = UUID.randomUUID().toString();
        this.bookName = bookName;
        this.writer = writer;
        this.description = description;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getDescription() {
        return description;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksModel that = (BooksModel) o;
        return Objects.equals(id, that.id) && Objects.equals(bookName, that.bookName) && Objects.equals(writer, that.writer) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, writer, description);
    }
}
