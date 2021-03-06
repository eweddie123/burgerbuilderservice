package burgerbuilder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import burgerbuilder.dao.CustomerRepository;
import burgerbuilder.domain.Customer;

@Service
@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/customer") // This means URL's start with gathering (after Application path)
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody Integer addNewCustomer (@RequestBody Customer customer) {	
		customerRepository.save(customer);
		return customer.getCustomerId();
	}	
	
	@DeleteMapping(path="/delete/{id}") // Map ONLY DELETE Requests
	public @ResponseBody String remove (@PathVariable("id") int id) {
		customerRepository.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping(path="/find/{id}") // Map ONLY GET Requests
	public @ResponseBody Optional<Customer> retrieve (@PathVariable("id") int id) {
		return customerRepository.findById(id);
	}
	
	@GetMapping(path="/find") // Map ONLY GET Requests
	public @ResponseBody Iterable<Customer> retrieve () {
		return customerRepository.findAll();
	}
}
