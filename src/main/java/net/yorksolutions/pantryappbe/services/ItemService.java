package net.yorksolutions.pantryappbe.services;

import net.yorksolutions.pantryappbe.models.Item;
import net.yorksolutions.pantryappbe.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Create
    public void createItem(Item item) throws Exception {
        String defaultImage = "https://via.placeholder.com/150\n" +
                "\n" +
                "C/O https://placeholder.com/";
        if (item == null)
            throw new Exception("Item cannot be null");
        Item newItem = new Item();
        newItem.setName(item.getName());
        if (item.getImage() == null || item.getImage().equals("")){
            item.setImage(defaultImage);
        }
        newItem.setImage(item.getImage());
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
    public void updateItem(Long id, Item item) throws Exception {
        String defaultImage = "https://via.placeholder.com/150\n" +
                "\n" +
                "C/O https://placeholder.com/";

        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty())
            throw new Exception("Item not found");

        Item itemToUpdate = itemOptional.get();
        itemToUpdate.setName(item.getName());
        if (item.getImage() == null || item.getImage().equals("")){
            itemToUpdate.setImage(defaultImage);
        }else if (item.getImage().equals(itemOptional.get().getImage())){
            itemToUpdate.setImage(itemOptional.get().getImage());
        }else {
            itemToUpdate.setImage(item.getImage());
        }

        itemToUpdate.setMetric(item.getMetric());
        itemToUpdate.setQuantity(item.getQuantity());
        itemToUpdate.setCalories(item.getCalories());
        itemToUpdate.setCategory(item.getCategory());

        itemRepository.save(itemToUpdate);
    }
    // Delete
    public void deleteItemById(Long id) throws Exception {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isEmpty())
            throw new Exception("Item not found");

        itemRepository.deleteById(id);
    }

}
