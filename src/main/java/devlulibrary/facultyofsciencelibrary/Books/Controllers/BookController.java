package devlulibrary.facultyofsciencelibrary.Books.Controllers;

import devlulibrary.facultyofsciencelibrary.Books.Dto.BookForCreationDto;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Services.BooksService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Books")
public class BookController {
    private final BooksService booksService;

    BookController(BooksService bookService) {
        this.booksService = bookService;
    }

    @GetMapping()
    public ResponseEntity<List<BooksForResponseDto>> getAllBook() {
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
    public ResponseEntity<BooksModel> uploadBook(@RequestBody BookForCreationDto book) {
        return this.booksService.uploadBook(book);
    }
}
