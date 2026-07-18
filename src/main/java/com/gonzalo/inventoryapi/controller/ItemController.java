package com.gonzalo.inventoryapi.controller;

import com.gonzalo.inventoryapi.model.Item;
import com.gonzalo.inventoryapi.repository.ItemRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/items")
public class ItemController{
    
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getallItems() {
        return itemRepository.findAll();
    }
    
}
