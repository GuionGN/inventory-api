package com.gonzalo.inventoryapi.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.gonzalo.inventoryapi.model.Item;
import com.gonzalo.inventoryapi.repository.ItemRepository;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

}
