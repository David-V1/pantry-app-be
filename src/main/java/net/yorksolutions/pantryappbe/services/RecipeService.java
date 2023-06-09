package net.yorksolutions.pantryappbe.services;

import lombok.AllArgsConstructor;
import net.yorksolutions.pantryappbe.DTO.RecipeDTO;
import net.yorksolutions.pantryappbe.models.Account;
import net.yorksolutions.pantryappbe.models.Recipe;
import net.yorksolutions.pantryappbe.repositories.AccountRepository;
import net.yorksolutions.pantryappbe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RecipeService {
    RecipeRepository recipeRepository;
    AccountRepository accountRepository;

    //Create
    public void createRecipe(Long id, RecipeDTO recipe) throws Exception{
        Optional<Account> account = accountRepository.findById(id);

        if (account.isEmpty())
            throw new Exception("Account not found");

        Recipe recipeToSave = new Recipe();
        recipeToSave.setName(recipe.name);
        recipeToSave.setImage(recipe.image);
        recipeToSave.setInstructions(recipe.instructions);
        recipeToSave.setAccount(account.get());

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
    public void updateRecipe(Long id, RecipeDTO recipeDTO) throws Exception {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isEmpty()) {
            throw new Exception("Recipe not found");
        }
        Recipe recipe = recipeOptional.get();
        recipe.setName(recipeDTO.name);
        recipe.setImage(recipeDTO.image);
        recipe.setInstructions(recipeDTO.instructions);
        recipeRepository.save(recipe);
    }
    //Delete
    public void deleteRecipeById(Long id) throws Exception{
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isEmpty())
            throw new Exception("Recipe not found");

        recipeRepository.deleteById(id);
    }
}
