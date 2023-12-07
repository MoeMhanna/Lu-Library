package devlulibrary.facultyofsciencelibrary.Reviews.Dto;

public class StarsCountDto {
    private int oneStarPercentage;
    private int twoStarsPercentage;
    private int threeStarsPercentage;
    private int fourStarsPercentage;
    private int fiveStarsPercentage;

    public StarsCountDto(int oneStarCount, int twoStarCount, int threeStarCount, int fourStarCount, int fiveStarCount) {
        this.oneStarPercentage = oneStarCount;
        this.twoStarsPercentage = twoStarCount;
        this.threeStarsPercentage = threeStarCount;
        this.fourStarsPercentage = fourStarCount;
        this.fiveStarsPercentage = fiveStarCount;
    }

    public int getOneStarPercentage() {
        return oneStarPercentage;
    }

    public void setOneStarPercentage(int oneStarPercentage) {
        this.oneStarPercentage = oneStarPercentage;
    }

    public int getTwoStarsPercentage() {
        return twoStarsPercentage;
    }

    public void setTwoStarsPercentage(int twoStarsPercentage) {
        this.twoStarsPercentage = twoStarsPercentage;
    }

    public int getThreeStarsPercentage() {
        return threeStarsPercentage;
    }

    public void setThreeStarsPercentage(int threeStarsPercentage) {
        this.threeStarsPercentage = threeStarsPercentage;
    }

    public int getFourStarsPercentage() {
        return fourStarsPercentage;
    }

    public void setFourStarsPercentage(int fourStarsPercentage) {
        this.fourStarsPercentage = fourStarsPercentage;
    }

    public int getFiveStarsPercentage() {
        return fiveStarsPercentage;
    }

    public void setFiveStarsPercentage(int fiveStarsPercentage) {
        this.fiveStarsPercentage = fiveStarsPercentage;
    }

}
