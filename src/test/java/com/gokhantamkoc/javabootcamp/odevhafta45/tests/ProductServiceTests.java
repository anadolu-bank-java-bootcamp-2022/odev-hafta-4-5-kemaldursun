package com.gokhantamkoc.javabootcamp.odevhafta45.tests;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Product;
import com.gokhantamkoc.javabootcamp.odevhafta45.repository.ProductRepository;
import com.gokhantamkoc.javabootcamp.odevhafta45.service.ProductService;
import com.gokhantamkoc.javabootcamp.odevhafta45.util.DatabaseConnection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ProductServiceTests {

    private ProductService productService;

    @Before
    public void setup() {
        this.productService = new ProductService(
                new ProductRepository(new DatabaseConnection())
        );
    }

    @Test
    public void CreateProductTest() {
        Product product = new Product(
        3L, "Test Product 1", "Test Product 1"
        );

        productService.createProduct(product);
        boolean actualResult = productService.deleteProduct(product.getId());
        assertThat(actualResult).isEqualTo(true);
    }

    @Test
    public void UpdateProductTest() {
        Product existingProduct = productService.getProduct(1L);
        assertThat(existingProduct).isNotEqualTo(null);
        Product updatedProduct = new Product(
        1L, "Test Product 1", "Test Product 1"
        );
        productService.updateProduct(updatedProduct);
        Product productAfterUpdate = productService.getProduct(1L);
        assertThat(productAfterUpdate.getId()).isEqualTo(1L);
        assertThat(productAfterUpdate.getName()).isEqualTo(updatedProduct.getName());
        assertThat(productAfterUpdate.getDescription()).isEqualTo(updatedProduct.getDescription());

        productService.updateProduct(existingProduct);
    }

    @Test
    public void ListProductTest() {
        List<Product> productList = productService.listProduct();
        assertThat(productList.size()).isEqualTo(2);
    }

    @Test
    public void GetProductTest() {
        Product existingProduct = productService.getProduct(1L);
        assertThat(existingProduct.getId()).isEqualTo(1L);
        assertThat(existingProduct.getName()).isEqualTo("Jedi Figure Set");
        assertThat(existingProduct.getDescription()).isEqualTo("May the 4th be with you!");
    }
}
