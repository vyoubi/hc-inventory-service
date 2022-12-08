package de.haegerconsulting.internShop.hcinventoryservice.services;

import de.haegerconsulting.internShop.hcinventoryservice.entities.Inventory;

import java.util.List;

public interface InventoryService {
    Boolean findBySkuCode(String skuCode);

    String saveInventory(Inventory inventory);

    List<Inventory> findAll();

    Inventory findByInventoryId(Long inventoryId);

    Inventory updateInventory(Inventory inventory);

    void deleteInventory(Long inventoryId);
}
