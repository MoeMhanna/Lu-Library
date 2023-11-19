package devlulibrary.facultyofsciencelibrary.Category.Controllers;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Services.BooksService;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    private final CategoryService categoryService;
    private final BooksService booksService;
    CategoryController(CategoryService categoryService,BooksService bookService){
        this.categoryService = categoryService;
        this.booksService = bookService;
    }
    @GetMapping
    public List<CategoryModel> listCategory(){
        return this.categoryService.getCategoryList();
    }
    @GetMapping("/{id}")
    public CategoryModel getCategoryById(String id){
        return this.categoryService.getCategoryById(id);
    }
    @GetMapping("/{category}")
    public List<BooksModel> getCategoryBooks( String category){
        List<BooksModel> books = booksService.getBooksList().stream()
                .filter(book -> book.getCategory().equals(this.categoryService.getCategoryById(category).getCategory()))
                .collect(Collectors.toList());
        return books;

    }
    @DeleteMapping("/{id}")
    public void deleteCategory(String id){
        this.categoryService.deleteCategory(id);
    }
    @PostMapping
    public void addCategory(CategoryModel category){
        this.categoryService.addCategory(category);
    }
}
