package burgerbuilder.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import burgerbuilder.domain.Ingredients;

public interface IngredientsRepository extends CrudRepository<Ingredients, Integer>{
	Iterable<Optional<Ingredients>> findByIngredientsId(Integer ingredientsId);
	Optional<Ingredients> findBySaladAndCheeseAndBaconAndMeat(Integer salad, Integer cheese, Integer bacon, Integer meat);
}
