package devlulibrary.facultyofsciencelibrary.Users.model;

import java.util.Objects;
import java.util.UUID;

public class UsersModel {
    private String id;
    private String username;
    private String email;
    private String Password;

    public UsersModel(String username, String email, String password) {
        id = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        Password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersModel that)) return false;
        return getId().equals(that.getId()) && getUsername().equals(that.getUsername()) && getEmail().equals(that.getEmail()) && getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getPassword());
    }
}
