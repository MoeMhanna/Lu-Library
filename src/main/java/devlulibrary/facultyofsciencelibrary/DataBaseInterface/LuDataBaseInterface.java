package devlulibrary.facultyofsciencelibrary.DataBaseInterface;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LuDataBaseInterface<T, TD> extends MongoRepository<T, TD> {
}
