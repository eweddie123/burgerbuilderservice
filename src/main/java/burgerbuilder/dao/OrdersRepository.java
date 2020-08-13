package burgerbuilder.dao;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import burgerbuilder.domain.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
	Iterable<Optional<Orders>> findByCustomer(Integer customer);
	Iterable<Optional<Orders>> findByDeliveryMethod(String deliveryMethod);
}
