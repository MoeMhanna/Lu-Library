package devlulibrary.facultyofsciencelibrary.Books.Dao;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Repositories.BookRepository;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BooksDao {
    @Autowired
    private BookRepository bookRepository;

    public BooksModel storeFile(BooksModel book) throws IOException {
        return bookRepository.save(book);
    }
}
