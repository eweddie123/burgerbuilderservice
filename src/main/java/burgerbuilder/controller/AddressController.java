package burgerbuilder.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import burgerbuilder.dao.AddressRepository;
import burgerbuilder.domain.Address;
@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/address") // This means URL's start with gathering (after Application path)
public class AddressController {
	@Autowired
	private AddressRepository addressRepository;
	
	
	
//	 public String addNewAddress (Address address) {
//		addressRepository.save(address);
//		return "Saved";
//	}
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewAddress (@RequestBody Address address) {
//		Location location = new Gson().fromJson(json, Location.class);
//		
//		Address address = new Address();
//		address.setCountry(location.getCountry());
//		address.setStreet(location.getStreet());
//		address.setZipcode(location.getZipcode());
//		
//		System.out.println(address.getAddressId());
		addressRepository.save(address);
		return "Saved";
	}
	
	@DeleteMapping(path="/delete/{id}") // Map ONLY DELETE Requests
	public @ResponseBody String remove (@PathVariable("id") int id) {
		addressRepository.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping(path="/get") // Map ONLY GET Requests
	public @ResponseBody Optional<Address> retrieve (@RequestParam String street, @RequestParam String zipcode, @RequestParam String country) {
		return addressRepository.findByStreetAndZipcodeAndCountry(street, zipcode, country);
	}
}
