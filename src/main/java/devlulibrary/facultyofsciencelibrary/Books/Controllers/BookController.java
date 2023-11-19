package devlulibrary.facultyofsciencelibrary.Books.Controllers;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Services.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {
    private final BooksService booksService;
    BookController(BooksService bookService){
        this.booksService = bookService;
    }
    @GetMapping
    public List<BooksModel> listBooks(){
        return this.booksService.getBooksList();
    }
    @GetMapping("/{id}")
    public BooksModel getBookById(String id){
        return this.booksService.getBookById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(String id){
        this.booksService.deleteBook(id);
    }
    @PostMapping
    public void addBook(BooksModel book){
        this.booksService.addBook(book);
    }
}
