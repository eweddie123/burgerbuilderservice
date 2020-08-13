package burgerbuilder.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import burgerbuilder.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Iterable<Optional<Customer>> findByCountry(String country);
	Iterable<Optional<Customer>> findByStreet(String street);
	Iterable<Optional<Customer>> findByZipcode(String zipcode);
}