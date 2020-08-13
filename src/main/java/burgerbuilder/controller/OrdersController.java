package burgerbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import burgerbuilder.dao.OrdersRepository;
import burgerbuilder.domain.Orders;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/orders") // This means URL's start with gathering (after Application path)
public class OrdersController {
	@Autowired
	private OrdersRepository ordersRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewOrders (@RequestBody Orders orders) {
//		Data data = new Gson().fromJson(json, Data.class);
//		
//		//ingredients
//		Ingredients ingredients = new Ingredients();
//		Ing ing = new Ing();
//		ingredients.setBacon(ing.getBacon());
//		ingredients.setCheese(ing.getCheese());
//		ingredients.setMeat(ing.getMeat());
//		ingredients.setSalad(ing.getSalad());
//		
//		//price
//		Integer price = data.getPrice();
//
//		//Delivery Method
//		String deliveryMethod = data.getDeliveryMethod();
//		
//		//Customer
//		Customer customer = new Customer();
//		CustomerDetails cust = data.getCustomer();
//		//customer.setAddress(addressId);
//		customer.setName(cust.getName());
//		customer.setEmail(cust.getEmail());
//		
//		
//		//Address
//		Address address = new Address();
//		Location loc = cust.getAddress();
//		address.setCountry(loc.getCountry());
//		address.setStreet(loc.getStreet());
//		address.setZipcode(loc.getStreet());
//		
//		//TODO: Customer Address and Ingredient Ids and call apis
//		//AddressController ac = new AddressController();
//		//ac.addNewAddress(address);
//		AddressRepository addressRepository = new AddressRepository();
//		customer.setAddressId(address.getAddressId());
//		
//		CustomerController cc = new CustomerController();
//		cc.addNewCustomer(customer);
//		
//		IngredientsController ic = new IngredientsController();
//		ic.addNewIngredients(ingredients);
//		
//		
//		Orders orders = new Orders();
//		orders.setCustomerId(customer.getCustomerId());
//		orders.setDeliveryMethod(deliveryMethod);
//		orders.setIngredients(ingredients.getIngredientsId());
//		orders.setPrice(price);
		ordersRepository.save(orders);
		
		return "Saved";
	}
	
	@DeleteMapping(path="/delete/{id}") // Map ONLY DELETE Requests
	public @ResponseBody String deleteAddress (@PathVariable("id") int id) {
		ordersRepository.deleteById(id);
		return "Deleted";
	}
}

//class Data {
//	private Ing ingredients;
//	private Integer price;
//	private CustomerDetails customer;
//	private String deliveryMethod;
//	
//	public void setIngredients(Ing ingredients) {
//		this.ingredients = ingredients;
//	}
//	public Ing getIngredients() {
//		return this.ingredients;
//	}
//	public void setPrice(Integer price) {
//		this.price = price;
//	}
//	public Integer getPrice() {
//		return this.price;
//	}
//	public void setCustomer(CustomerDetails customer) {
//		this.customer = customer;
//	}
//	public CustomerDetails getCustomer() {
//		return this.customer;
//	}
//	public void setDeliveryMethod(String deliveryMethod) {
//		this.deliveryMethod = deliveryMethod;
//	}
//	public String getDeliveryMethod() {
//		return this.deliveryMethod;
//	}
//}
//
//class Ing {
//	private Integer bacon;
//	private Integer cheese;
//	private Integer salad;
//	private Integer meat;
//	
//	public void setBacon(Integer bacon) {
//		this.bacon = bacon;
//	}
//	public Integer getBacon() {
//		return this.bacon;
//	}
//	public void setCheese(Integer cheese) {
//		this.cheese = cheese;
//	}
//	public Integer getCheese() {
//		return this.cheese;
//	}
//	public void setSalad(Integer salad) {
//		this.salad = salad;
//	}
//	public Integer getSalad() {
//		return this.salad;
//	}
//	public void setMeat(Integer meat) {
//		this.meat = meat;
//	}
//	public Integer getMeat() {
//		return this.meat;
//	}
//}
//
//class CustomerDetails {
//	private String name;
//	private Location address;
//	private String email;
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getName() {
//		return this.name;
//	}
//	public void setAddress(Location address) {
//		this.address = address;
//	}
//	public Location getAddress() {
//		return this.address;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}	
//	public String getEmail() {
//		return this.email;
//	}
//}
//
//class Location {
//	private String street;
//	private String zipcode;
//	private String country;
//	
//	public void setStreet(String street) {
//		this.street = street;
//	}
//	public String getStreet() {
//		return this.street;
//	}
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}
//	public String getZipcode() {
//		return this.zipcode;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
//	public String getCountry() {
//		return this.country;
//	}
//}
