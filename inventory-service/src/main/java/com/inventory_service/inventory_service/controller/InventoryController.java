package com.inventory_service.inventory_service.controller;

import com.inventory_service.inventory_service.model.Inventory;
import com.inventory_service.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    @Autowired
    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventory(@PathVariable String productId) {
        Optional<Inventory> inventory = service.getInventoryByProductId(productId);
        return inventory.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable String productId, @RequestParam int quantity) {
        return ResponseEntity.ok(service.updateInventory(productId, quantity));
    }
}
