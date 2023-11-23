package devlulibrary.facultyofsciencelibrary.Category.Controllers;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
    @GetMapping("/{categoryName}/books")
    public ResponseEntity<List<BooksForResponseDto>> getCategoryBooks(@PathVariable String categoryName){
        return this.categoryService.getCategoryBooks(categoryName);
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
