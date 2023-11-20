package devlulibrary.facultyofsciencelibrary.Authentication.Controllers;

import devlulibrary.facultyofsciencelibrary.Authentication.Dto.LoginDto;
import devlulibrary.facultyofsciencelibrary.Authentication.Dto.RegisterDto;
import devlulibrary.facultyofsciencelibrary.Authentication.Services.AuthenticationService;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Authentication")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<UsersModel> login(@RequestBody LoginDto loginDto) {
        return authenticationService.login(loginDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UsersModel> addUser(@RequestBody RegisterDto registerDto) {
        return this.authenticationService.registerUser(registerDto);
    }
}