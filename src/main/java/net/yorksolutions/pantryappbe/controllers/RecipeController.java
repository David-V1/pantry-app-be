package net.yorksolutions.pantryappbe.controllers;

import lombok.AllArgsConstructor;
import net.yorksolutions.pantryappbe.DTO.RecipeDTO;
import net.yorksolutions.pantryappbe.models.Recipe;
import net.yorksolutions.pantryappbe.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor //DI Injection
@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {

    RecipeService recipeService;

    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public void createRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
       try {
           recipeService.createRecipe(id, recipeDTO);
       } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
       }
    }

    // Read
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable Long id) {
        try {
            return recipeService.getRecipeById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // Update
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        try {
            recipeService.updateRecipe(id, recipeDTO);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRecipeById(@PathVariable Long id) {
        try {
            recipeService.deleteRecipeById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
