package devlulibrary.facultyofsciencelibrary.Books.Dao;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Users.model.UsersModel;

import java.util.ArrayList;
import java.util.List;

public class BooksDao {
    private List<BooksModel> booksList = new ArrayList<>();
    public BooksDao() {
        booksList.add(new BooksModel("MMurder on the orient express", "Agatha", "Crime..."));
    }
    public List<BooksModel> getBooksList() {
        return booksList;
    }
    public BooksModel getBookById(String id) {
        return booksList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    //add book with lambda expression and search if exist or not
    public void addBook(BooksModel book) {
        booksList.stream().filter(t -> t.getId().equals(book.getId())).findFirst().ifPresentOrElse(t -> {
            throw new IllegalStateException("User already exist");
        }, () -> {
            booksList.add(book);
        });
    }

    //delete book with lambda expression and search if exist or not
    public void deleteBook(String id) {
        booksList.stream().filter(t -> t.getId().equals(id)).findFirst().ifPresentOrElse(t -> {
            booksList.remove(t);
        }, () -> {
            throw new IllegalStateException("User not exist");
        });
    }

    //update book with lambda expression and search if exist or not
    public void updateUser(String id, BooksModel book) {
        booksList.stream().filter(t -> t.getId().equals(id)).findFirst().ifPresentOrElse(t -> {
            booksList.set(booksList.indexOf(t), book);
        }, () -> {
            throw new IllegalStateException("User not exist");
        });
    }
}
