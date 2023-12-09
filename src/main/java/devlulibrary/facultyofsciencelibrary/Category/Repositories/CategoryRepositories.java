package devlulibrary.facultyofsciencelibrary.Category.Repositories;

import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;
import devlulibrary.facultyofsciencelibrary.DataBaseInterface.LuDataBaseInterface;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepositories extends LuDataBaseInterface<CategoryModel,String> {
    Optional<CategoryModel> findCategoryByCategoryName(String categoryName);
    void deleteCategoryByCategoryName(String categoryName);
}

