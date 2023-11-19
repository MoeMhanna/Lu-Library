package devlulibrary.facultyofsciencelibrary.Books.Dao;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import devlulibrary.facultyofsciencelibrary.Category.Model.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class BooksDao {
    private List<BooksModel> booksList = new ArrayList<>();
    public BooksDao() {
        booksList.add(new BooksModel("Murder on the orient express", "Agatha", "Crime...",new CategoryModel("Math")));
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
            throw new IllegalStateException("Book already exist");
        }, () -> {
            booksList.add(book);
        });
    }

    //delete book with lambda expression and search if exist or not
    public void deleteBook(String id) {
        booksList.stream().filter(t -> t.getId().equals(id)).findFirst().ifPresentOrElse(t -> {
            booksList.remove(t);
        }, () -> {
            throw new IllegalStateException("Book does not exist");
        });
    }

    //update book with lambda expression and search if exist or not
    public void updateBook(String id, BooksModel book) {
        booksList.stream().filter(t -> t.getId().equals(id)).findFirst().ifPresentOrElse(t -> {
            booksList.set(booksList.indexOf(t), book);
        }, () -> {
            throw new IllegalStateException("Book does not exist");
        });
    }
}
