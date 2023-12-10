package devlulibrary.facultyofsciencelibrary.DataBaseInterface;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

//Generic interface for all the repositories
// This interface is used to extend the MongoRepository interface and to be used in other interfaces
@NoRepositoryBean
public interface LuDataBaseInterface<T, TD> extends MongoRepository<T, TD> {
}
