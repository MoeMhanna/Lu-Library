package devlulibrary.facultyofsciencelibrary.Users.Repositories;

import devlulibrary.facultyofsciencelibrary.DataBaseInterface.LuDataBaseInterface;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;

import java.util.Optional;

public interface UsersRepositories extends LuDataBaseInterface<UsersModel, String> {
    Optional<UsersModel> findUsersModelByEmail(String email);
}
