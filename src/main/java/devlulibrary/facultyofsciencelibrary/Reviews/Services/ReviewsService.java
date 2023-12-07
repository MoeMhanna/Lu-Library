package devlulibrary.facultyofsciencelibrary.Reviews.Services;

import devlulibrary.facultyofsciencelibrary.Books.Dao.BooksDao;
import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Reviews.Dao.ReviewsDao;
import devlulibrary.facultyofsciencelibrary.Reviews.Dto.ReviewsForCreationDto;
import devlulibrary.facultyofsciencelibrary.Reviews.Dto.ReviewsForResponseDto;
import devlulibrary.facultyofsciencelibrary.Reviews.Dto.StarsCountDto;
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

    private Boolean checkUserPresence(String userId) {
        try {
            return usersDao.getUserById(userId) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private Boolean checkBookPresence(String bookId) {
        try {
            return booksDao.getBookById(bookId) != null;
        } catch (Exception e) {
            return false;
        }
    }

    private List<ReviewsForResponseDto> getReviewsResponseDto(List<ReviewsModel> reviewsList) {
        if (reviewsList.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        List<ReviewsForResponseDto> reviewResponseDtoList = new ArrayList<>();
        for (ReviewsModel review : reviewsList) {
            reviewResponseDtoList.add(new ReviewsForResponseDto(review.getId(), review.getBookId(), review.getReview(), review.getUsername(), review.getStarLevel()));
        }
        return reviewResponseDtoList;
    }

    public ResponseEntity<List<ReviewsForResponseDto>> getBookReviews(String id) {
        if (!checkBookPresence(id)) {
            return ResponseEntity.notFound().build();
        }
        List<ReviewsModel> reviews = reviewsDao.getAllReviews().stream().filter(review -> review.getBookId().equals(id)).collect(Collectors.toList());
        List<ReviewsForResponseDto> reviewResponseDtoList = getReviewsResponseDto(reviews);
        return ResponseEntity.ok(reviewResponseDtoList);
    }

    public ResponseEntity<StarsCountDto> getReviewsPercentages() {
        List<ReviewsForResponseDto> reviewResponseDtoList = getReviewsResponseDto(reviewsDao.getAllReviews());
        System.out.println(reviewResponseDtoList.size());
        int totalStarsCount = reviewResponseDtoList.size();
        int oneStarCount = reviewsDao.getAllReviews().stream().filter(review -> review.getStarLevel() == 1).toList().size();
        int twoStarCount = reviewsDao.getAllReviews().stream().filter(review -> review.getStarLevel() == 2).toList().size();
        int threeStarCount = reviewsDao.getAllReviews().stream().filter(review -> review.getStarLevel() == 3).toList().size();
        int fourStarCount = reviewsDao.getAllReviews().stream().filter(review -> review.getStarLevel() == 4).toList().size();
        int fiveStarCount = reviewsDao.getAllReviews().stream().filter(review -> review.getStarLevel() == 5).toList().size();

        int oneStarPercentage = (oneStarCount * 100) / totalStarsCount;
        int twoStarPercentage = (twoStarCount * 100) / totalStarsCount;
        int threeStarPercentage = (threeStarCount * 100) / totalStarsCount;
        int fourStarPercentage = (fourStarCount * 100) / totalStarsCount;
        int fiveStarPercentage = (fiveStarCount * 100) / totalStarsCount;
        System.out.println(fiveStarPercentage);
        System.out.println(totalStarsCount);
        StarsCountDto starsCountDto = new StarsCountDto(oneStarPercentage, twoStarPercentage, threeStarPercentage, fourStarPercentage, fiveStarPercentage);
        return ResponseEntity.ok(starsCountDto);
    }

    public ResponseEntity<ReviewsModel> addReview(String bookId, ReviewsForCreationDto review) {
        if (!checkUserPresence(review.getUserId()) || !checkBookPresence(bookId)) {
            return ResponseEntity.badRequest().build();
        }
        try {
            UsersModel user = usersDao.getUserById(review.getUserId());
            ReviewsModel reviewsModel = new ReviewsModel(bookId, review.getReview(), user.getUsername(), review.getUserId(), review.getStarsLevel());
            reviewsDao.addReview(reviewsModel);
            return ResponseEntity.status(HttpStatusCode.valueOf(201)).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
    }
}
