package devlulibrary.facultyofsciencelibrary.Authentication.Services;

import devlulibrary.facultyofsciencelibrary.Authentication.Dto.LoginDto;
import devlulibrary.facultyofsciencelibrary.Authentication.Dto.RegisterDto;
import devlulibrary.facultyofsciencelibrary.Users.Dto.UserForCreationDto;
import devlulibrary.facultyofsciencelibrary.Users.Enumerables.UserRole;
import devlulibrary.facultyofsciencelibrary.Users.Services.UserServices;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {
    private final UserServices usersServices;

    public AuthenticationService(UserServices userServices) {
        this.usersServices = userServices;
    }

    public ResponseEntity<UsersModel> login(LoginDto loginDto) {
        List<UsersModel> userList = usersServices.getUsersList().getBody();
        if (userList == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
        }
        for (UsersModel user : userList) {
            if ((user.getEmail().equals(loginDto.getUsernameOrEmail()) || user.getUsername().equals(loginDto.getUsernameOrEmail()))
                    && user.getPassword().equals(loginDto.getPassword())) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(403)).build();
    }

    public ResponseEntity<UsersModel> registerUser(RegisterDto registerDto) {
        UserForCreationDto user = new UserForCreationDto(registerDto.getUsername(), registerDto.getEmail(), UserRole.USER, registerDto.getPassword());
        return this.usersServices.addUser(user);
    }
}
