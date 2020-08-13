package burgerbuilder.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import burgerbuilder.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Iterable<Optional<Customer>> findByAddress(Integer address);
	Iterable<Optional<Customer>> findByEmail(String email);
	Iterable<Optional<Customer>> findByName(String name);
	Optional<Customer> findByNameAndAddressAndEmail(String name, Integer address, String email);
}