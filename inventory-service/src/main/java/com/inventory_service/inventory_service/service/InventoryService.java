package com.inventory_service.inventory_service.service;

import com.inventory_service.inventory_service.model.Inventory;
import com.inventory_service.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public Optional<Inventory> getInventoryByProductId(String productId) {
        return repository.findByProductId(productId);
    }

    public Inventory updateInventory(String productId, int quantity) {
        Inventory inventory = repository.findByProductId(productId).orElse(new Inventory());
        inventory.setProductId(productId);
        inventory.setQuantity(quantity);
        return repository.save(inventory);
    }
}
