package devlulibrary.facultyofsciencelibrary.Books.Repositories;

import devlulibrary.facultyofsciencelibrary.Books.Model.BooksModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BooksModel, String> {
}
