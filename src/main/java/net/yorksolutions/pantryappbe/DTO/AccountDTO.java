package net.yorksolutions.pantryappbe.DTO;

import java.util.List;
import java.util.Optional;

public class AccountDTO {

    Optional<Long> id;
    public String email;
    public String password;
    public String familyName;

    public List<RecipeDTO> recipes;

    public List<ItemDTO> items;
}
