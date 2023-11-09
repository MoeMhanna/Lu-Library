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
}
