package devlulibrary.facultyofsciencelibrary.Books.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Books")
public class BookController {
    @GetMapping
    public String getAllBooks(){
        return "Hello";
    }
}
