package devlulibrary.facultyofsciencelibrary.Reviews.Respositories;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.DataBaseInterface.LuDataBaseInterface;
import devlulibrary.facultyofsciencelibrary.Reviews.Model.ReviewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReviewsRepositories extends LuDataBaseInterface<ReviewsModel, String> {
}
