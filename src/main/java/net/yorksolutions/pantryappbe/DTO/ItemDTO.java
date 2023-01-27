package net.yorksolutions.pantryappbe.DTO;

import java.util.Optional;

public class ItemDTO {
    public Optional<Long> id;
    public String name;
    public String image;
    public Double weight;
    public String metric;
    public Integer quantity;
    public Integer calories;
    public String category;
    public AccountDTO account;
}
