package devlulibrary.facultyofsciencelibrary.Books.Dao;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Books.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BooksDao {
    @Autowired
    private BookRepository bookRepository;

    public BooksModel storeFile(BooksModel book) throws IOException {
        return bookRepository.save(book);
    }

    public List<BooksModel> getAllBook() {
        return bookRepository.findAll();
    }

    public BooksModel getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Book not exist"));
    }
    public void deleteBookById(String id){
        bookRepository.deleteById(id);
    }
}
