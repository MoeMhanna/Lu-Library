package devlulibrary.facultyofsciencelibrary.Users.model;

import devlulibrary.facultyofsciencelibrary.Users.Enumerables.UserRole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Document
public class UsersModel {
    @Id
    private String id;
    private String username;
    private String email;
    private UserRole role;
    private String password;
    private Date createdOn;

    public UsersModel() {
    }

    public UsersModel(String username, String email, UserRole role, String password) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = password;
        this.createdOn = new Date();

    }

    public String getId() {
        return id;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setPassword(String password) {
        password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
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
