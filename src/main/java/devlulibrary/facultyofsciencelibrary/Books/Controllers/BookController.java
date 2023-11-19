package devlulibrary.facultyofsciencelibrary.Books.Controllers;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Services.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {
    private final BooksService booksServices;
    BookController(BooksService bookServices){
        this.booksServices = bookServices;
    }
    @GetMapping
    public List<BooksModel> listUsers(){
        return this.booksServices.getBooksDao();
    }
    @GetMapping("/{id}")
    public BooksModel getBookById(String id){
        return this.booksServices.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(String id){
        this.booksServices.deleteBook(id);
    }

    @PostMapping
    public void addBook(BooksModel book){
        this.booksServices.addBook(book);
    }

}
