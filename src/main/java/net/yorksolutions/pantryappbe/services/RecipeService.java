package net.yorksolutions.pantryappbe.services;

import lombok.AllArgsConstructor;
import net.yorksolutions.pantryappbe.DTO.RecipeDTO;
import net.yorksolutions.pantryappbe.models.Recipe;
import net.yorksolutions.pantryappbe.repositories.RecipeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RecipeService {
    RecipeRepository recipeRepository;

    //Create
    public void createRecipe(RecipeDTO recipe) throws Exception{
        Optional<Recipe> recipeOptional = recipeRepository.findByName(recipe.name);
        if (recipeOptional.isPresent()) {
            throw new Exception("Recipe already exists");
        }

        Recipe recipeToSave = new Recipe();
        recipeToSave.setName(recipe.name);
        recipeToSave.setImage(recipe.image);
        recipeToSave.setInstructions(recipe.instructions);

        recipeRepository.save(recipeToSave);

    }
    //Read
    public List<Recipe> getAllRecipes() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) throws Exception{
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isPresent()) {
            return recipeOptional.get();
        }
        throw new Exception("Recipe not found");
    }
    //Update
    //Delete
    public void deleteRecipeById(Long id) throws Exception{
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isEmpty())
            throw new Exception("Recipe not found");

        recipeRepository.deleteById(id);
    }
}
