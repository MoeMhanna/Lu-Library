package devlulibrary.facultyofsciencelibrary.Reviews.Dto;

public class ReviewsForCreationDto {
    private String bookId;
    private String review;
    private String userId;

    public ReviewsForCreationDto(String bookId,String review,String userId) {
        this.bookId = bookId;
        this.review = review;
        this.userId = userId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
