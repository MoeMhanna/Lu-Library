package devlulibrary.facultyofsciencelibrary.Users.Dto;

import devlulibrary.facultyofsciencelibrary.Users.Enumerables.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserForCreationDto {
    @NotEmpty
    private final String username;
    @NotEmpty
    @Email
    private final String email;
    private final UserRole role;
    @NotEmpty
    private final String Password;

    public UserForCreationDto(String username, String email, UserRole role, String password) {
        this.username = username;
        this.email = email;
        this.role = role;
        Password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }

    public UserRole getRole() {
        return role;
    }
}
