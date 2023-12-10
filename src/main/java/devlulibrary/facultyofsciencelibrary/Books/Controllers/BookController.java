package devlulibrary.facultyofsciencelibrary.Books.Controllers;

import devlulibrary.facultyofsciencelibrary.Books.Dto.BookForCreationDto;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Services.BooksService;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Category.Service.CategoryService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Books")
public class BookController {
    private final BooksService booksService;
    private final CategoryService categoryService;

    BookController(BooksService bookService,
                   CategoryService categoryService) {
        this.booksService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<BooksForResponseDto>> getAllBook(@RequestParam(name = "categoryId", required = false) String categoryId) {
        if (categoryId != null)
            return categoryService.getCategoryBooks(categoryId);
        return booksService.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BooksForResponseDto> getBookById(@PathVariable String id) {
        return booksService.getBookById(id);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String id) {
        return booksService.downloadFile(id);
    }

    @PostMapping
    public ResponseEntity<BooksModel> uploadBook(@RequestParam("bookName") String bookName,
                                                 @RequestParam("writer") String writer,
                                                 @RequestParam("description") String description,
                                                 @RequestParam("category") String category,
                                                 @RequestParam("file") MultipartFile file) {
        return this.booksService.uploadBook(bookName, writer, description, category, file);
    }
}
