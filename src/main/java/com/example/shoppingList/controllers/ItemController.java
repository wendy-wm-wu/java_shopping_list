package com.example.shoppingList.controllers;

import com.example.shoppingList.models.Item;
import com.example.shoppingList.services.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path="api/items")
public class ItemController {

    @Autowired
    private IItemService items;

    @Autowired
    public ItemController(IItemService items) {
        this.items = items;
    }

    @PostMapping(value="",
                    produces = APPLICATION_JSON_UTF8_VALUE,
                    consumes = APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Item storeItem(@RequestBody Item item) {
        Item data = null;
        try {
            data = items.createItem(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @GetMapping(value="/{itemId}", produces = APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Item retrieveItem(@PathVariable("itemId") String itemId) {
        Item data = null;
        try {
            data = items.findItem(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DeleteMapping(value="/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId) {
        try {
            items.deleteItem(itemId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value="", produces = APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Collection<Item> findItems() {
        Collection<Item> data = null;
        try {
            data = items.findItems();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
