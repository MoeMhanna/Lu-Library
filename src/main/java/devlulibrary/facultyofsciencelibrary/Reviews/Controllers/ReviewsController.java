package devlulibrary.facultyofsciencelibrary.Reviews.Controllers;

import devlulibrary.facultyofsciencelibrary.Reviews.Dto.ReviewsForCreationDto;
import devlulibrary.facultyofsciencelibrary.Reviews.Dto.ReviewsForResponseDto;
import devlulibrary.facultyofsciencelibrary.Reviews.Dto.StarsCountDto;
import devlulibrary.facultyofsciencelibrary.Reviews.Model.ReviewsModel;
import devlulibrary.facultyofsciencelibrary.Reviews.Services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reviews")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("stars-percentages")
    public ResponseEntity<StarsCountDto> reviewsStarsCount() {
        return this.reviewsService.getReviewsPercentages();
    }

    @GetMapping("/{id}/book-reviews")
    public ResponseEntity<List<ReviewsForResponseDto>> getBookReviews(@PathVariable String id) {
        return this.reviewsService.getBookReviews(id);
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<ReviewsModel> addReview(@PathVariable String bookId, @RequestBody ReviewsForCreationDto review) {
        return this.reviewsService.addReview(bookId, review);
    }
}
