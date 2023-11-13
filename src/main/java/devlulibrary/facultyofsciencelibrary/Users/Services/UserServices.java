package devlulibrary.facultyofsciencelibrary.Users.Services;

import devlulibrary.facultyofsciencelibrary.Users.Dao.UsersDao;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserServices {
    private final UsersDao usersDao = new UsersDao();

    //get users
    public List<UsersModel> getUsersDao() {
        return usersDao.getUsersList();
    }

    //get user by id
    public UsersModel getUserById(String id) {
        try {
            return usersDao.getUserById(id);
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalStateException("User not exist");
        }
    }

    //add user
    public void addUser(UsersModel user) {
        usersDao.addUser(user);
    }

    //delete user
    public void deleteUser(String id) {
        usersDao.deleteUser(id);
    }
}
