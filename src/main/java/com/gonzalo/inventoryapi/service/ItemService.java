package com.gonzalo.inventoryapi.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.gonzalo.inventoryapi.exception.ItemNotFoundException;
import com.gonzalo.inventoryapi.model.Item;
import com.gonzalo.inventoryapi.repository.ItemRepository;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item no encontrado"));
    }

    public Item update(Long id, Item itemActualizado) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item no encontrado"));

        item.setName(itemActualizado.getName());
        item.setQuantity(itemActualizado.getQuantity());
        item.setPrice(itemActualizado.getPrice());

        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public Item delete(Long id){
        Item item = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item no encontrado"));

        itemRepository.deleteById(id);

        return item;
        
    }

}
