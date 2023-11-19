package devlulibrary.facultyofsciencelibrary.Books.Model;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;

import java.util.Objects;
import java.util.UUID;

public class BooksModel {
    private String id;
    private String bookname;
    private String writer;
    private String description;
    private CategoryModel category;
    public BooksModel(String bookname, String writer, String description,CategoryModel category) {
        id = UUID.randomUUID().toString();
        this.bookname = bookname;
        this.writer = writer;
        this.description = description;
        this.category=category;
    }

    public String getCategory() {
        return category.getCategory();
    }

    public void setCategory(CategoryModel category) {
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

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
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
        return id == that.id && Objects.equals(bookname, that.bookname) && Objects.equals(writer, that.writer) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookname, writer, description);
    }
}
