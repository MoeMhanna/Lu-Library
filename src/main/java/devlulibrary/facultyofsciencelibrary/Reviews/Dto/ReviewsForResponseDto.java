package devlulibrary.facultyofsciencelibrary.Reviews.Dto;

public class ReviewsForResponseDto {
    private String id;
    private String bookId;
    private String review;
    private String username;

    public ReviewsForResponseDto(String id,String bookId,String review,String username) {
        this.id = id;
        this.bookId = bookId;
        this.review = review;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
