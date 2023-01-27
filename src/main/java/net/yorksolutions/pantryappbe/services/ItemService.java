package net.yorksolutions.pantryappbe.services;

import net.yorksolutions.pantryappbe.DTO.ItemDTO;
import net.yorksolutions.pantryappbe.models.Account;
import net.yorksolutions.pantryappbe.models.Item;
import net.yorksolutions.pantryappbe.repositories.AccountRepository;
import net.yorksolutions.pantryappbe.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;

    public ItemService(ItemRepository itemRepository, AccountRepository accountRepository) {
        this.itemRepository = itemRepository;
        this.accountRepository = accountRepository;
    }

    // Create
    public void createItem(Long accountId, ItemDTO item) throws Exception {
        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isEmpty()) {
            throw new Exception("Account not found");
        }
        Account account = accountOptional.get();
        String defaultImage = "https://www.jpgteam.com/wp-content/uploads/2017/06/placeholder-4-500x300.png";

        if (item == null)
            throw new Exception("Item cannot be null");

        Item newItem = new Item();

        if (item.image.equals("") && item.image.equals("Dairy & Alternatives")) {
            newItem.setImage("https://www.pngarts.com/files/1/Dairy-PNG-Image-Background.png");
        }

        if (item.image.equals("") && item.category.equals("Fruits")) {
            newItem.setImage("https://www.pngkey.com/png/full/4-48879_fruit-png-fruits-png.png");
        }

        if (item.image.equals("")) {
            newItem.setImage(defaultImage);
        }

        newItem.setName(item.name);
        newItem.setImage(item.image);
        //newItem.setImage(item.getImage());
        newItem.setWeight(item.weight);
        newItem.setMetric(item.metric);
        newItem.setQuantity(item.quantity);
        newItem.setCalories(item.calories);
        newItem.setCategory(item.category);
        newItem.setAccount(account);
        itemRepository.save(newItem);
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
