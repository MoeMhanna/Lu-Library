package devlulibrary.facultyofsciencelibrary.Category.Controllers;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Services.BooksService;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    private final CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<List<CategoryModel>> listCategory(){
        return this.categoryService.getCategoryList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCategoryById(@PathVariable String id){
        return this.categoryService.getCategoryById(id);
    }
    @GetMapping("/{id}/books")
    public ResponseEntity<List<BooksModel>> getCategoryBooks(@PathVariable String id){
        return this.categoryService.getCategoryBooks(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryModel> deleteCategory(String id){
        return this.categoryService.deleteCategory(id);
    }
    @PostMapping
    public ResponseEntity<CategoryModel> addCategory(@RequestBody CategoryModel category){
        return this.categoryService.addCategory(category);
    }
}
