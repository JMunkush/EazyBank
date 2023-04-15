package io.munkush.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.munkush.com.entity.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
