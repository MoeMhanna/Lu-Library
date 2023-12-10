package devlulibrary.facultyofsciencelibrary.Category.Dto;

public class CategoryForCreationDto {
    private String categoryName;

    public CategoryForCreationDto() {
    }
    public CategoryForCreationDto(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
