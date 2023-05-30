package hpi.proj1ct.maxivitaminbot.model;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Metz on 20.05.23
 */
@Repository
public interface UserRepository  extends CrudRepository<User,Long> {


}
