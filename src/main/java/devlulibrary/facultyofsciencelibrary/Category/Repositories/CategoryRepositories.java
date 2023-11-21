package devlulibrary.facultyofsciencelibrary.Category.Repositories;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepositories extends MongoRepository <CategoryModel,String>{
    Optional<CategoryModel> findCategoryModelByCategory(String category);
    Optional<CategoryModel> deleteCategoryModelByCategory(String category);
}
