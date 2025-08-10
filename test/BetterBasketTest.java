


import catalogue.BetterBasket;
import catalogue.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BetterBasketTest {

    private BetterBasket betterBasket;

    @BeforeEach
    void setUp() {
        betterBasket = new BetterBasket();
    }

    @Test
    void add_mergesDuplicateProducts() {
        Product product1 = new Product("0001", "Toaster", 29.99, 1);
        Product product2 = new Product("0002", "Kettle", 19.99, 1);
        Product product3 = new Product("0001", "Toaster", 29.99, 2); // Duplicate with quantity 2

        betterBasket.add(product1);
        betterBasket.add(product2);
        betterBasket.add(product3);

        assertEquals(2, betterBasket.size()); // Check basket size
        
        // Check merged product quantity
        Product toasterProduct = null;
        Product kettleProduct = null;
        for (Product product : betterBasket) {
            if (product.getProductNum().equals("0001")) {
                toasterProduct = product;
            } else if (product.getProductNum().equals("0002")) {
                kettleProduct = product;
            }
        }
        
        assertNotNull(toasterProduct, "Toaster product should exist");
        assertNotNull(kettleProduct, "Kettle product should exist");
        assertEquals(3, toasterProduct.getQuantity()); // 1 + 2 = 3
        assertEquals(1, kettleProduct.getQuantity()); // Unchanged
    }

    @Test
    void sort_sortsProductsByProductNum() {
        Product product1 = new Product("0003", "Toaster", 29.99, 1);
        Product product2 = new Product("0001", "Kettle", 19.99, 1);
        Product product3 = new Product("0002", "Microwave", 39.99, 1);

        betterBasket.add(product1);
        betterBasket.add(product2);
        betterBasket.add(product3);

        betterBasket.sort();

        assertEquals("0001", betterBasket.get(0).getProductNum());
        assertEquals("0002", betterBasket.get(1).getProductNum());
        assertEquals("0003", betterBasket.get(2).getProductNum());
    }

    @Test
    void add_singleProduct() {
        Product product = new Product("0001", "Toaster", 29.99, 1);
        betterBasket.add(product);
        
        assertEquals(1, betterBasket.size());
        assertEquals("0001", betterBasket.get(0).getProductNum());
        assertEquals(1, betterBasket.get(0).getQuantity());
    }

    @Test
    void add_multipleQuantitiesOfSameProduct() {
        Product product1 = new Product("0001", "Toaster", 29.99, 3);
        Product product2 = new Product("0001", "Toaster", 29.99, 5);
        
        betterBasket.add(product1);
        betterBasket.add(product2);
        
        assertEquals(1, betterBasket.size());
        assertEquals(8, betterBasket.get(0).getQuantity()); // 3 + 5 = 8
    }

    @Test
    void sort_emptyBasket() {
        betterBasket.sort(); // Should not throw exception
        assertEquals(0, betterBasket.size());
    }

    @Test
    void sort_singleProduct() {
        Product product = new Product("0001", "Toaster", 29.99, 1);
        betterBasket.add(product);
        betterBasket.sort();
        
        assertEquals(1, betterBasket.size());
        assertEquals("0001", betterBasket.get(0).getProductNum());
    }
}