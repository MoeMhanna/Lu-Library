package devlulibrary.facultyofsciencelibrary.Reviews.Respositories;

import devlulibrary.facultyofsciencelibrary.Reviews.Model.ReviewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReviewsRepositories extends MongoRepository<ReviewsModel, String> {
}
