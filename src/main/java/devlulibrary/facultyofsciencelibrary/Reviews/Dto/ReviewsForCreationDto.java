package devlulibrary.facultyofsciencelibrary.Reviews.Dto;

public class ReviewsForCreationDto {
    private String review;
    private String userId;
    private int starsLevel;

    public ReviewsForCreationDto(String review, String userId, int starsCount) {
        this.review = review;
        this.userId = userId;
        this.starsLevel = starsCount;
    }

    public int getStarsLevel() {
        return starsLevel;
    }

    public void setStarsLevel(int starsLevel) {
        this.starsLevel = starsLevel;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
