package net.yorksolutions.pantryappbe.repositories;


import net.yorksolutions.pantryappbe.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Optional<Ingredient> findByRecipesId(Long id);

}