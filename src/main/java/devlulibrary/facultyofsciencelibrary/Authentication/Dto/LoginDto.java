package devlulibrary.facultyofsciencelibrary.Authentication.Dto;

public class LoginDto {

    private final String usernameOrEmail;
    private final String password;

    public LoginDto(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }
}
