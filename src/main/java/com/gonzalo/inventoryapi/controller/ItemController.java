package com.gonzalo.inventoryapi.controller;

import com.gonzalo.inventoryapi.model.Item;
import com.gonzalo.inventoryapi.service.ItemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/items")
public class ItemController{

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getallItems() {
        return itemService.findAll();
    }

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@Valid @RequestBody Item item) {
        return itemService.save(item);
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @Valid @RequestBody Item item){
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable long id){
        itemService.delete(id);
    }
}
