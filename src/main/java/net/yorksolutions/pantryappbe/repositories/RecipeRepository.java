package net.yorksolutions.pantryappbe.repositories;

import net.yorksolutions.pantryappbe.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Optional<Recipe> findByName(String name);

}
