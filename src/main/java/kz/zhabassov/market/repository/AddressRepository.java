package kz.zhabassov.market.repository;

import kz.zhabassov.market.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
