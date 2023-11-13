package devlulibrary.facultyofsciencelibrary.Users.Controllers;

import devlulibrary.facultyofsciencelibrary.Users.Services.UserServices;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UsersControllers {
    private final UserServices usersServices;
    UsersControllers(UserServices userServices){
        this.usersServices = userServices;
    }

    @GetMapping
    public List<UsersModel> listUsers(){
        return this.usersServices.getUsersDao();
    }

    @GetMapping("/{id}")
    public UsersModel getUserById(String id){
        return this.usersServices.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(String id){
        this.usersServices.deleteUser(id);
    }

    @PostMapping
    public void addUser(UsersModel user){
        this.usersServices.addUser(user);
    }
}
