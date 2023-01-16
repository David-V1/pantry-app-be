package net.yorksolutions.pantryappbe.controllers;

import net.yorksolutions.pantryappbe.models.Item;
import net.yorksolutions.pantryappbe.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createItem(@RequestBody Item item){
        try {
            itemService.createItem(item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }
    // Read
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        try {
            return itemService.getItemById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody Item item) {
        try {
            itemService.updateItem(id, item);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        try {
            itemService.deleteItemById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
