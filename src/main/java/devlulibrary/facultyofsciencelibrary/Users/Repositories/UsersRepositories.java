package devlulibrary.facultyofsciencelibrary.Users.Repositories;

import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepositories extends MongoRepository<UsersModel, String> {
    Optional<UsersModel> findUsersModelByEmail(String email);
}
