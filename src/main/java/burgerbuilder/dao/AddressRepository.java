package burgerbuilder.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import burgerbuilder.domain.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
	Iterable<Optional<Address>> findByAddressId(Integer addressId);
	Iterable<Optional<Address>> findByCountry(String country);
	Iterable<Optional<Address>> findByStreet(String street);
	Iterable<Optional<Address>> findByZipcode(String zipcode);
	Optional<Address> findByStreetAndZipcodeAndCountry(String street, String zipcode, String country);
}
