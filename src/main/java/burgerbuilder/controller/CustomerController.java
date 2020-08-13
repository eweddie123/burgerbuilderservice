package burgerbuilder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import burgerbuilder.dao.CustomerRepository;
import burgerbuilder.domain.Customer;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/customer") // This means URL's start with gathering (after Application path)
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
//	public String addNewCustomer (Customer customer) {
//		customerRepository.save(customer);
//		return "Saved";
//	}
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewCustomer (@RequestBody Customer customer) {
//		
//		CustomerDetails details = new Gson().fromJson(json, CustomerDetails.class);
//		Customer customer = new Customer();
//		
//		//Address
//		AddressController ac = new AddressController();
//		Location loc = details.getAddress();
//		String street = loc.getStreet();
//		String zipcode = loc.getZipcode();
//		String country = loc.getCountry();
//		
//		Optional<Address> address = ac.getAddress(street, zipcode, country);
//		if (address.equals(null)) {
//			Address newAddress = new Address();
//			newAddress.setCountry(country);
//			newAddress.setStreet(street);
//			newAddress.setZipcode(zipcode);
//			ac.addNewAddress(newAddress);
//			customer.setAddressId(newAddress.getAddressId());
//		} else {
//			customer.setAddressId(address.get().getAddressId());
//		}
//		customer.setEmail(details.getEmail());
//		customer.setName(details.getName());
		
		customerRepository.save(customer);
		return "Saved";
	}
	@GetMapping(path="/get") // Map ONLY POST Requests
	public @ResponseBody Optional<Customer> retrieve (@RequestParam String name, @RequestParam Integer address, @RequestParam String email) {
		return customerRepository.findByNameAndAddressAndEmail(name, address, email);
	}
	//TODO: Add GET and PUT APIs
}
