package net.yorksolutions.pantryappbe.services;

import lombok.AllArgsConstructor;
import net.yorksolutions.pantryappbe.DTO.IngredientDTO;
import net.yorksolutions.pantryappbe.models.Ingredient;
import net.yorksolutions.pantryappbe.models.Recipe;
import net.yorksolutions.pantryappbe.repositories.IngredientRepository;
import net.yorksolutions.pantryappbe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class IngredientService {
    IngredientRepository ingredientRepository;
    RecipeRepository recipeRepository;

        // Create
        public void createIngredient(IngredientDTO ingredientDTO, Long recipeId) {
            Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
            if (recipeOptional.isEmpty()) {
                throw new RuntimeException("Recipe not found");
            }

            Ingredient ingredient = new Ingredient();
            ingredient.setName(ingredientDTO.name);
            ingredient.setWeight(ingredientDTO.weight);
            ingredient.setQuantity(ingredientDTO.quantity);
            ingredient.setMetric(ingredientDTO.metric);
            ingredient.setRecipes(recipeOptional.get()); //TODO: Check this
            ingredientRepository.save(ingredient);
        }

        // Read
        public List<Ingredient> getAllIngredients(){
            return (List<Ingredient>)ingredientRepository.findAll();
        }

        public Ingredient getIngredientById(Long id) throws Exception {
            Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
            if (ingredientOptional.isPresent()){
                return ingredientOptional.get();
            } else {
                throw new Exception("Ingredient not found");
            }
        }

        //TODO: Repository method not returning
        public List<Ingredient> getIngredientsByRecipeId(Long recipeID)  {
            Optional<Ingredient> ingredientOptional = ingredientRepository.findByRecipesId(recipeID);
            if (ingredientOptional.isPresent()){
                return (List<Ingredient>) ingredientOptional.get();
            } else {
                throw new RuntimeException("Ingredient not found");
            }
        }

        // Update

        // Delete
        public void deleteIngredientById(Long id) throws Exception {
            Optional<Ingredient> ingredientOptional = ingredientRepository.findById(id);
            if (ingredientOptional.isPresent()){
                ingredientRepository.deleteById(id);
            } else {
                throw new Exception("Ingredient not found");
            }
        }

}
