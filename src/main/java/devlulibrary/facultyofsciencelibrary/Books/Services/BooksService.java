package devlulibrary.facultyofsciencelibrary.Books.Services;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Dao.CategoryDao;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class BooksService {
    private final BooksDao booksDao=new BooksDao();
    private final CategoryDao categoryDao=new CategoryDao();
    public List<BooksModel> getBooksList() {
        return booksDao.getBooksList();
    }
    public BooksModel getBookById(String id) {
        try {
            return booksDao.getBookById(id);
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalStateException("Book deos not exist");
        }
    }
    public void addBook(BooksModel book) {
        if(categoryDao.getCategoryId(book.getCategory())!=null){
            booksDao.addBook(book);
        }
        else{
            System.out.println("Category does not exist. Unable to add the book.");
        }
    }
    public void deleteBook(String id) {
        booksDao.deleteBook(id);
    }
}
