package com.gonzalo.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gonzalo.inventoryapi.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
}