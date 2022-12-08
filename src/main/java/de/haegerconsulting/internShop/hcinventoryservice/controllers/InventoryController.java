package de.haegerconsulting.internShop.hcinventoryservice.controllers;

import de.haegerconsulting.internShop.hcinventoryservice.entities.Inventory;
import de.haegerconsulting.internShop.hcinventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    Boolean isInStock(@PathVariable("skuCode") String skuCode) {
        return inventoryService.findBySkuCode(skuCode);
    }

    @PostMapping
    public String createInventory(@RequestBody Inventory inventory) {
        return inventoryService.saveInventory(inventory);
    }

    @GetMapping
    public List<Inventory> findAll() {
        return inventoryService.findAll();
    }

    @PutMapping("/update/{id}")
    public Inventory editInventory(@PathVariable("id") Long inventoryId, @RequestBody Inventory inventory) {
        Inventory existedInventory = inventoryService.findByInventoryId(inventoryId);

        if (existedInventory != null) {
            existedInventory.setSkuCode(inventory.getSkuCode());
            existedInventory.setStock(inventory.getStock());
            return inventoryService.updateInventory(existedInventory);
        } else {
            return null;
        }
    }

    @DeleteMapping("/remove/{id}")
    public void deleteInventory(@PathVariable("id") Long inventoryId) {
        inventoryService.deleteInventory(inventoryId);
    }
}
