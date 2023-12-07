package devlulibrary.facultyofsciencelibrary.Reviews.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class ReviewsModel {
    @Id
    private String Id;
    private String bookId;
    private String userId;
    private String username;
    private String review;
    private int starLevel;

    public ReviewsModel() {
    }

    public ReviewsModel(String bookId, String review, String username, String userId, int starLevel) {
        this.bookId = bookId;
        this.review = review;
        this.username = username;
        this.userId = userId;
        this.starLevel = starLevel;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewsModel that = (ReviewsModel) o;
        return Objects.equals(Id, that.Id) && Objects.equals(bookId, that.bookId) && Objects.equals(review, that.review) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, bookId, review, username);
    }
}
