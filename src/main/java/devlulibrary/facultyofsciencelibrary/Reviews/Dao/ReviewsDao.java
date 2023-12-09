package devlulibrary.facultyofsciencelibrary.Reviews.Dao;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Reviews.Model.ReviewsModel;
import devlulibrary.facultyofsciencelibrary.Reviews.Respositories.ReviewsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsDao {
    @Autowired
    ReviewsRepositories reviewsRepositories;
    public List<ReviewsModel> getAllReviews() {
        return reviewsRepositories.findAll();
    }

    public ReviewsModel getReviewId(String id) {
        /* lambda expression that provide the exception to be thrown in case the review is not found in the repository.  */
        return reviewsRepositories.findById(id)
                .orElseThrow(() -> new IllegalStateException("Review does not exist"));
    }
    public ReviewsModel addReview(ReviewsModel review) {
        return reviewsRepositories.save(review);
    }
}
