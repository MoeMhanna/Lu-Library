package devlulibrary.facultyofsciencelibrary.Reviews.Dto;

public class ReviewsForCreationDto {
    private String bookId;
    private String review;
    private String userId;

    public ReviewsForCreationDto(String bookId,String review,String userId) {
        this.bookId = bookId;
    }
}
