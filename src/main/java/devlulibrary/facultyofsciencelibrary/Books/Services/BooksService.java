package devlulibrary.facultyofsciencelibrary.Books.Services;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class BooksService {
    private final BooksDao booksDao=new BooksDao();
    public List<BooksModel> getBooksList() {
        return booksDao.getBooksList();
    }
    public BooksModel getBookById(String id) {
        try {
            return booksDao.getBookById(id);
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalStateException("User not exist");
        }
    }
    public void addBook(BooksModel book) {
        booksDao.addBook(book);
    }
    public void deleteBook(String id) {
        booksDao.deleteBook(id);
    }
}
