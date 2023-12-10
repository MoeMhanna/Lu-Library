package devlulibrary.facultyofsciencelibrary.Books.Repositories;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.DataBaseInterface.LuDataBaseInterface;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends LuDataBaseInterface<BooksModel, String> {
}
