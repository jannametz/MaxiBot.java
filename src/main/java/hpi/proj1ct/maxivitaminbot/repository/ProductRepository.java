package hpi.proj1ct.maxivitaminbot.repository;

import hpi.proj1ct.maxivitaminbot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jana Metz on 01.06.23
 */
@Repository

public interface ProductRepository extends CrudRepository<Product,Long> {

}
