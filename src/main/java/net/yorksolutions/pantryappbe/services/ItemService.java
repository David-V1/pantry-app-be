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
        String defaultImage = "https://www.jpgteam.com/wp-content/uploads/2017/06/placeholder-4-500x300.png";

        if (item == null)
            throw new Exception("Item cannot be null");

        Item newItem = new Item();

        if (item.getImage().equals("") && item.getCategory().equals("Dairy & Alternatives")) {
           item.setImage("https://www.pngarts.com/files/1/Dairy-PNG-Image-Background.png");
        }

        if (item.getImage().equals("") && item.getCategory().equals("Fruits")) {
           item.setImage("https://www.pngkey.com/png/full/4-48879_fruit-png-fruits-png.png");
        }

        if (item.getImage().equals("")) {
            item.setImage(defaultImage);
        }

        newItem.setName(item.getName());
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
        String defaultImage = "https://www.jpgteam.com/wp-content/uploads/2017/06/placeholder-4-500x300.png";

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
        itemToUpdate.setWeight(item.getWeight());
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
