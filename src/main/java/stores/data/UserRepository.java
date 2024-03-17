package stores.data;

import org.springframework.data.repository.CrudRepository;
import stores.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
