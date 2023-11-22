package devlulibrary.facultyofsciencelibrary.Books.Dto;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;

public class BooksForResponseDto {
    private String id;
    private String bookName;
    private String writer;
    private String description;
    private CategoryModel category;

    public BooksForResponseDto(String id, String bookName, String writer, String description, CategoryModel category) {
        this.id = id;
        this.bookName = bookName;
        this.writer = writer;
        this.description = description;
        this.category = category;
    }

    public BooksForResponseDto() {
    }

    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
