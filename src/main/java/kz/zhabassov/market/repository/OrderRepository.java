package kz.zhabassov.market.repository;

import kz.zhabassov.market.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
