package devlulibrary.facultyofsciencelibrary.Category.Controllers;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Service.CategoryService;
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
    public List<CategoryModel> listCategory(){
        return this.categoryService.getCategoryList();
    }
    @GetMapping("/{id}")
    public CategoryModel getCategoryById(String id){
        return this.categoryService.getCategoryById(id);
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
