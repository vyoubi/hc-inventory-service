package de.haegerconsulting.internShop.hcinventoryservice.serviceImpl;

import de.haegerconsulting.internShop.hcinventoryservice.InventoryRepository;
import de.haegerconsulting.internShop.hcinventoryservice.contrats.Product;
import de.haegerconsulting.internShop.hcinventoryservice.entities.Inventory;
import de.haegerconsulting.internShop.hcinventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final RestTemplate restTemplate;

    @Override
    public Boolean findBySkuCode(String skuCode) {
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Cannot Find Product by sku code " + skuCode));
        return inventory.getStock() > 0;
    }

    @Override
    public String saveInventory(Inventory inventory) {
        Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/api/products/product/name/" + inventory.getSkuCode(), Product.class);
        if (product != null) {
            inventoryRepository.save(inventory);
            return "Inventory added successfully";
        } else {
            return "No product with the name " + inventory.getSkuCode() + " found";
        }
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory findByInventoryId(Long inventoryId) {
        return inventoryRepository.findByInventoryId(inventoryId);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteInventory(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}
