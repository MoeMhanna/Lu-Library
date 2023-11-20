package devlulibrary.facultyofsciencelibrary.Users.Dao;

import devlulibrary.facultyofsciencelibrary.Users.Repositories.UsersRepositories;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersDao {
    private final UsersRepositories usersRepositories;

    public UsersDao(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }

    public List<UsersModel> getUsersList() {
        System.out.println(usersRepositories.findAll());
        return usersRepositories.findAll();
    }

    public UsersModel getUserById(String id) {
        return this.usersRepositories.findById(id).orElseThrow(() -> new IllegalStateException("User not exist"));
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
        System.out.println(exist);
        if (!exist) {
            throw new IllegalStateException();
        }
        usersRepositories.deleteById(id);
    }
}
