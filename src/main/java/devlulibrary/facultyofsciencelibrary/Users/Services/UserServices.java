package devlulibrary.facultyofsciencelibrary.Users.Services;

import devlulibrary.facultyofsciencelibrary.Users.Dao.UsersDao;
import devlulibrary.facultyofsciencelibrary.Users.Dto.UserForCreationDto;
import devlulibrary.facultyofsciencelibrary.Users.Enumerables.UserRole;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserServices {
    private final UsersDao usersDao;

    public UserServices(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public ResponseEntity<List<UsersModel>> getUsersList() {
        return ResponseEntity.ok().body(usersDao.getUsersList());
    }

    public ResponseEntity<UsersModel> getUserById(String id) {
        try {
            return ResponseEntity.ok(usersDao.getUserById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<UsersModel> addUser(UserForCreationDto user) {
        if (user.getRole() != UserRole.USER && user.getRole() != UserRole.ADMIN) {
            return ResponseEntity.badRequest().build();
        }
        UsersModel newUser = new UsersModel(user.getUsername(), user.getEmail(), user.getRole(), user.getPassword());
        try {
            return ResponseEntity.ok(usersDao.addUser(newUser));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(409)).build();
        }
    }

    public ResponseEntity<UsersModel> deleteUser(String id) {
        try {
            usersDao.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
