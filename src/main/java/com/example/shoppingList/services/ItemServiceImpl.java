package com.example.shoppingList.services;

import com.example.shoppingList.exceptions.NotFoundException;
import com.example.shoppingList.models.Item;
import com.example.shoppingList.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class ItemServiceImpl implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item findItem(String itemId) {
        Optional<Item> item = itemRepository.findById(itemId);

        return item.orElse(null);

    }

    @Override
    public void deleteItem(String itemId) {
        Optional<Item> item = itemRepository.findById(itemId);

        if (item.isEmpty()) {
            throw new NotFoundException("No item with ID " + itemId);
        }

        itemRepository.delete(item.get());
    }

    @Override
    public Collection<Item> findItems() {
        Iterable<Item> retrievedItems = itemRepository.findAll();
        Collection<Item> items;

        items = (Collection) retrievedItems;
        return items;
    }
}
