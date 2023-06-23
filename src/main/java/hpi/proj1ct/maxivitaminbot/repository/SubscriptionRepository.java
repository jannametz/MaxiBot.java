package hpi.proj1ct.maxivitaminbot.repository;
import hpi.proj1ct.maxivitaminbot.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Metz on 21.05.23
 */
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}