package net.yorksolutions.pantryappbe.DTO;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {
    public Long id;
    public String name;
    public String image;
    public String instructions;
    public List<IngredientDTO> ingredients;
}