package devlulibrary.facultyofsciencelibrary.Users.Dao;

import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;

import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    private List<UsersModel> usersList = new ArrayList<>();

    public UsersDao() {
        usersList.add(new UsersModel("Mhanna", "hamoudmehanna@gmail.com", "P@ssw0rd!"));
    }

    public List<UsersModel> getUsersList() {
        return usersList;
    }

    //get user by id with lambda expression
    public UsersModel getUserById(String id) {
        return usersList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    //add user with lambda expression and search if exist or not
    public void addUser(UsersModel user) {
        usersList.stream().filter(t -> t.getId().equals(user.getId())).findFirst().ifPresentOrElse(t -> {
            throw new IllegalStateException("User already exist");
        }, () -> {
            usersList.add(user);
        });
    }

    //delete user with lambda expression and search if exist or not
    public void deleteUser(String id) {
        usersList.stream().filter(t -> t.getId().equals(id)).findFirst().ifPresentOrElse(t -> {
            usersList.remove(t);
        }, () -> {
            throw new IllegalStateException("User not exist");
        });
    }

    //update user with lambda expression and search if exist or not
    public void updateUser(String id, UsersModel user) {
        usersList.stream().filter(t -> t.getId().equals(id)).findFirst().ifPresentOrElse(t -> {
            usersList.set(usersList.indexOf(t), user);
        }, () -> {
            throw new IllegalStateException("User not exist");
        });
    }
}
