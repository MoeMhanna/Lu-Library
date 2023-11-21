package devlulibrary.facultyofsciencelibrary.Users.Dto;

import devlulibrary.facultyofsciencelibrary.Users.Enumerables.UserRole;
import jakarta.validation.constraints.NotNull;

public class UserForCreationDto {
    @NotNull
    private final String username;
    @NotNull
    private final String email;
    @NotNull
    private final UserRole role;
    @NotNull
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
