package devlulibrary.facultyofsciencelibrary.Reviews.Services;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Dto.BooksForResponseDto;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.Reviews.Dao.ReviewsDao;
import devlulibrary.facultyofsciencelibrary.Reviews.Dto.ReviewsForCreationDto;
import devlulibrary.facultyofsciencelibrary.Reviews.Dto.ReviewsForResponseDto;
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
    private List<ReviewsForResponseDto> getResponseDto(List<ReviewsModel> reviewsList){
        if (reviewsList.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        List<ReviewsForResponseDto> reviewResponseDtoList=new ArrayList<>();
        for (ReviewsModel review : reviewsList) {
            reviewResponseDtoList.add(new ReviewsForResponseDto(review.getId(),review.getBookId(), review.getReview(), review.getUsername()));
        }
        return reviewResponseDtoList;
    }
    public ResponseEntity<List<ReviewsForResponseDto>> getBookReviews(String id){
        List<ReviewsModel> reviews= reviewsDao.getAllReviews().stream()
                .filter(review -> review.getBookId().equals(id))
                .collect(Collectors.toList());
        List<ReviewsForResponseDto> reviewResponseDtosList=getResponseDto(reviews);
        return ResponseEntity.ok(reviewResponseDtosList);
    }
    public ResponseEntity<List<ReviewsForResponseDto>> getReviewsList() {
        List<ReviewsForResponseDto> reviewResponseDtoList=getResponseDto(reviewsDao.getAllReviews());
        return ResponseEntity.ok(reviewResponseDtoList);
    }
    public ResponseEntity<ReviewsForResponseDto> getReviewById(String id) {
        try {
            ReviewsModel reviewsModel=reviewsDao.getReviewId(id);
            return ResponseEntity.ok(new ReviewsForResponseDto(reviewsModel.getId(), reviewsModel.getBookId(), reviewsModel.getReview(), reviewsModel.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<ReviewsModel> addReview(ReviewsForCreationDto review)
    {
        if (!checkReviewValidation(review.getBookId(),review.getUserId())) {
            return ResponseEntity.badRequest().build();
        }
        try {
            reviewsDao.addReview(new ReviewsModel(review.getBookId(), review.getReview(),usersDao.getUserById(review.getUserId()).getUsername() , review.getUserId()));
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
