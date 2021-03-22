package com.example.shoppingList;

import com.example.shoppingList.models.Item;
import com.example.shoppingList.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ShoppingListApplication implements CommandLineRunner  {

	private final ItemRepository itemRepository;

	@Autowired
	public ShoppingListApplication(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (itemRepository.findAll().isEmpty()) {

			itemRepository.save(new Item("milk", new Date()));
			itemRepository.save(new Item("eggs", new Date()));
		}

		for (Item item: itemRepository.findAll()) {
			System.out.println(item);
		}
	}
}
