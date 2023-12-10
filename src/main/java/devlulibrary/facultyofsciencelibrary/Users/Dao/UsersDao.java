package devlulibrary.facultyofsciencelibrary.Users.Dao;

import devlulibrary.facultyofsciencelibrary.Users.Repositories.UsersRepositories;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Data Access Object (Dao) is a design pattern that provides an abstract interface to some type of database or other persistence mechanism.
// and it is also a proxy fot the database. so it is respecting Proxy design pattern.
public class UsersDao {
    private final UsersRepositories usersRepositories;

    public UsersDao(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }

    public List<UsersModel> getUsersList() {
        return usersRepositories.findAll();
    }

    public UsersModel getUserById(String id) {
        /* lambda expression that provides the exception to be thrown in case the user is not found in the repository.  */
        return this.usersRepositories.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not exist"));
    }

    public UsersModel addUser(UsersModel user) {
        boolean exist = usersRepositories.findUsersModelByEmail(user.getEmail()).isPresent();
        if (exist) {
            throw new IllegalStateException();
        }
        return usersRepositories.save(user);
    }

    public void deleteUser(String id) {
        boolean exist = usersRepositories.findById(id).isPresent();
        if (!exist) {
            throw new IllegalStateException();
        }
        usersRepositories.deleteById(id);
    }
}
