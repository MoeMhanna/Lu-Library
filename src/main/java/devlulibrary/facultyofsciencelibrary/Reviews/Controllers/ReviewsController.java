package devlulibrary.facultyofsciencelibrary.Reviews.Controllers;

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
    @GetMapping
    public ResponseEntity<List<ReviewsModel>> reviewsList(){
        return this.reviewsService.getReviewsList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReviewsModel> getReviewById(@PathVariable String id){
        return this.reviewsService.getReviewById(id);
    }
    @GetMapping("/{id}/books")
    public ResponseEntity<List<ReviewsModel>> getBookReviews(@PathVariable String id){
        return this.reviewsService.getBookReviews(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteReview(String id){
        return this.reviewsService.deleteReview(id);
    }
    @PostMapping
    public ResponseEntity<ReviewsModel> addReview(@RequestBody ReviewsModel review){
        return this.reviewsService.addReview(review);
    }
}