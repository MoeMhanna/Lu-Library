package devlulibrary.facultyofsciencelibrary.Users.Controllers;

import devlulibrary.facultyofsciencelibrary.Users.Dto.UserForCreationDto;
import devlulibrary.facultyofsciencelibrary.Users.Services.UserServices;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UsersControllers {
    private final UserServices usersServices;

    UsersControllers(UserServices userServices) {
        this.usersServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<UsersModel>> listUsers() {
        return this.usersServices.getUsersList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersModel> getUserById(@PathVariable String id) {
        return this.usersServices.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UsersModel> addUser(@Valid @RequestBody UserForCreationDto user) {
        return this.usersServices.addUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsersModel> deleteUser(@PathVariable String id) {
        return this.usersServices.deleteUser(id);
    }
}
