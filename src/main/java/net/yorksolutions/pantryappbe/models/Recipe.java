package net.yorksolutions.pantryappbe.models;

import java.util.ArrayList;

public class Recipe {
    private Long id;
    private String name;
    private String image;
    private ArrayList<String> ingredients;
    private String instructions;

    public Recipe(Long id, String name, String image, ArrayList<String> ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Recipe() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
