package net.yorksolutions.pantryappbe.repositories;

import net.yorksolutions.pantryappbe.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAllByCategory(String category);
}
