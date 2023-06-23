package hpi.proj1ct.maxivitaminbot.repository;
import hpi.proj1ct.maxivitaminbot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Metz on 21.05.23
 */
@Repository
public interface UserRepository  extends CrudRepository<User,Long> {
}
