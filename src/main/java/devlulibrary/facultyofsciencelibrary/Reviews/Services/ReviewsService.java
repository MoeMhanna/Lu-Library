package devlulibrary.facultyofsciencelibrary.Reviews.Services;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Reviews.Dao.ReviewsDao;
import devlulibrary.facultyofsciencelibrary.Reviews.Model.ReviewsModel;
import devlulibrary.facultyofsciencelibrary.Users.Dao.UsersDao;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class ReviewsService {
    @Autowired
    private ReviewsDao reviewsDao;
    @Autowired
    public BooksDao booksDao;
    @Autowired
    public UsersDao usersDao;
    private Boolean checkReviewValidation(String id,String user) {
        try{
            BooksModel check=booksDao.getBookById(id);
            UsersModel check2=usersDao.getUserById(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public ResponseEntity<List<ReviewsModel>> getBookReviews(String id){
        List<ReviewsModel> reviews= reviewsDao.getAllReviews().stream()
                .filter(review -> review.getBookId().equals(id))
                .collect(Collectors.toList());
        return ResponseEntity.ok(reviews);
    }
    public ResponseEntity<List<ReviewsModel>> getReviewsList() {
        return ResponseEntity.ok(reviewsDao.getAllReviews());
    }
    public ResponseEntity<ReviewsModel> getReviewById(String id) {
        try {
            return ResponseEntity.ok(reviewsDao.getReviewId(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<ReviewsModel> addReview(ReviewsModel review)
    {
        if (!checkReviewValidation(review.getBookId(),review.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        try {
            reviewsDao.addReview(review);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
    }
    public ResponseEntity deleteReview(String id) {
        try {
            reviewsDao.deleteReview(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
