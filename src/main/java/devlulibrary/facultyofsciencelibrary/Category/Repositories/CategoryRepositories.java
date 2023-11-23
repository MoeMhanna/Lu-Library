package devlulibrary.facultyofsciencelibrary.Category.Repositories;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepositories extends MongoRepository <CategoryModel,String>{
    Optional<CategoryModel> findCategoryByCategoryName(String categoryName);
    void deleteCategoryByCategoryName(String categoryName);
}

