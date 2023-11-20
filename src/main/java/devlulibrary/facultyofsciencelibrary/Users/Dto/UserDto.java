package devlulibrary.facultyofsciencelibrary.Users.Dto;

public class UserDto {
    private final String username;
    private final String email;
    private final String Password;

    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        Password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { return Password; }
}
