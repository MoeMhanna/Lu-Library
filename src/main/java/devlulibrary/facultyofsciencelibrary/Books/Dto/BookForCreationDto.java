package devlulibrary.facultyofsciencelibrary.Books.Dto;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.web.multipart.MultipartFile;

public class BookForCreationDto {
    private String bookName;
    private String writer;
    private String description;
//    private CategoryModel category;
    private MultipartFile file;

    public BookForCreationDto(String bookName, String writer, String description, CategoryModel category, MultipartFile file) {
        this.bookName = bookName;
        this.writer = writer;
        this.description = description;
//        this.category = category;
        this.file = file;
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

//    public CategoryModel getCategory() {
//        return category;
//    }
//
//    public void setCategory(CategoryModel category) {
//        this.category = category;
//    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
