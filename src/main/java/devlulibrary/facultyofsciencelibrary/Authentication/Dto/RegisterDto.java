package devlulibrary.facultyofsciencelibrary.Authentication.Dto;

import jakarta.validation.constraints.NotNull;

public class RegisterDto {

    @NotNull
    private final String username;
    @NotNull
    private final String email;
    @NotNull
    private final String password;

    public RegisterDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
