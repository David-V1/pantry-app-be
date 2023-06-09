package net.yorksolutions.pantryappbe.DTO;

import net.yorksolutions.pantryappbe.models.Recipe;

import java.util.List;
import java.util.Optional;

public class IngredientDTO {

    public Optional<Long> id;

    public String name;

    public Double weight;

    public Integer quantity;

    public String metric;

    public List<Recipe> recipes;
}
