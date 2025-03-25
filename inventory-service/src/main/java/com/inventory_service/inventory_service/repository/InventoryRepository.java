package com.inventory_service.inventory_service.repository;

import com.inventory_service.inventory_service.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {
    Optional<Inventory> findByProductId(String productId);
}
