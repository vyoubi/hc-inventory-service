package de.haegerconsulting.internShop.hcinventoryservice.contrats;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
}
