package devlulibrary.facultyofsciencelibrary.Users.Controllers;

import devlulibrary.facultyofsciencelibrary.Users.Services.UserServices;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
