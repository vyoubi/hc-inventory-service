package de.haegerconsulting.internShop.hcinventoryservice;

import de.haegerconsulting.internShop.hcinventoryservice.contrats.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    private Product product;
}

