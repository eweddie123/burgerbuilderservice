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

import burgerbuilder.dao.IngredientsRepository;
import burgerbuilder.domain.Ingredients;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/ingredients") // This means URL's start with gathering (after Application path)
public class IngredientsController {
	@Autowired
	private IngredientsRepository ingredientsRepository;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewIngredients (@RequestBody Ingredients ingredients) {
		ingredientsRepository.save(ingredients);
		return "Saved";
	}
	@GetMapping(path="/get") // Map ONLY POST Requests
	public @ResponseBody Optional<Ingredients> retrieve (@RequestParam Integer salad, @RequestParam Integer cheese, @RequestParam Integer bacon, @RequestParam Integer meat) {
		return ingredientsRepository.findBySaladAndCheeseAndBaconAndMeat(salad, cheese, bacon, meat);
	}
	
	@DeleteMapping(path="/delete/{id}") // Map ONLY DELETE Requests
	public @ResponseBody String remove (@PathVariable("id") int id) {
		ingredientsRepository.deleteById(id);
		return "Deleted";
	}
	//TODO: GET PUT
}
