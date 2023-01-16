package net.yorksolutions.pantryappbe.services;

import net.yorksolutions.pantryappbe.models.Item;
import net.yorksolutions.pantryappbe.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Create
    public void createItem(Item item) throws Exception {
        if (item == null)
            throw new Exception("Item cannot be null");
        Item newItem = new Item();
        newItem.setName(item.getName());
        newItem.setImage(item.getImage());
        newItem.setWeight(item.getWeight());
        newItem.setMetric(item.getMetric());
        newItem.setQuantity(item.getQuantity());
        newItem.setCalories(item.getCalories());
        newItem.setCategory(item.getCategory());
        itemRepository.save(item);
    }
    // Read
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) throws Exception {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty())
            throw new Exception("Item not found");

        return itemOptional.get();
    }


    // Update
    // Delete
    public void deleteItemById(Long id) throws Exception {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty())
            throw new Exception("Item not found");

        itemRepository.deleteById(id);
    }

}
