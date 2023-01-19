package net.yorksolutions.pantryappbe.controllers;

import net.yorksolutions.pantryappbe.DTO.IngredientDTO;
import lombok.AllArgsConstructor;
import net.yorksolutions.pantryappbe.models.Ingredient;
import net.yorksolutions.pantryappbe.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@RestController
@RequestMapping("/ingredient")
@CrossOrigin
public class IngredientController {

    IngredientService ingredientService;

    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/recipeId/{recipeId}")
    public void createIngredient(@RequestBody IngredientDTO ingredientDTO, @PathVariable Long recipeId) {
        ingredientService.createIngredient(ingredientDTO, recipeId);
    }


    // Read
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        try {
            return ingredientService.getIngredientById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/recipes/{recipeId}")
    public Iterable<Ingredient> getAllIngredientsById(@PathVariable Long recipeId) {
        try {
            return ingredientService.getIngredientsByRecipeId(recipeId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found", e);
        }
    }
    // Update
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateIngredient(@PathVariable Long id, @RequestBody IngredientDTO ingredient) {
        try {
            ingredientService.updateIngredient(id, ingredient);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteIngredientById(@PathVariable Long id){
        try {
            ingredientService.deleteIngredientById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
