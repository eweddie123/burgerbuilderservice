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

import burgerbuilder.dao.OrdersRepository;
import burgerbuilder.domain.Orders;

@Service
@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/orders") // This means URL's start with gathering (after Application path)
public class OrdersController {
	@Autowired
	private OrdersRepository ordersRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody Integer addNewOrders (@RequestBody Orders orders) {
		ordersRepository.save(orders);
		return orders.getOrdersId();
	}
	
	@DeleteMapping(path="/delete/{id}") // Map ONLY DELETE Requests
	public @ResponseBody String remove (@PathVariable("id") int id) {
		ordersRepository.deleteById(id);
		return "Deleted";
	}
	
	@GetMapping(path="/find/{id}") // Map ONLY GET Requests
	public @ResponseBody Optional<Orders> retrieve (@PathVariable("id") int id) {
		return ordersRepository.findById(id);
	}
	
	@GetMapping(path="/find") // Map ONLY GET Requests
	public @ResponseBody Iterable<Orders> retrieve () {
		return ordersRepository.findAll();
	}
}
