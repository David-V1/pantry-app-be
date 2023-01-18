package net.yorksolutions.pantryappbe.DTO;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeDTO {
    public Optional<Long> id;
    public String name;
    public String image;
    public String instructions;
    public List<IngredientDTO> ingredients;
    public List<AccountDTO> accounts;
}