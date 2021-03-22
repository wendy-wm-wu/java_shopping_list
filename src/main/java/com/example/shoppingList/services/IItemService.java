package com.example.shoppingList.services;

import com.example.shoppingList.models.Item;

import java.util.Collection;

public interface IItemService {

    Item createItem(Item item);

    Item findItem(String itemId);

    void deleteItem(String itemId);

    Collection<Item> findItems();
}
