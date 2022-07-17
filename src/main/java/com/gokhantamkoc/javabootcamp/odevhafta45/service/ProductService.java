package com.gokhantamkoc.javabootcamp.odevhafta45.service;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Product;
import com.gokhantamkoc.javabootcamp.odevhafta45.repository.ProductRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product newProduct) { productRepository.save(newProduct); }

    public Product getProduct(long id) { return productRepository.get(id); }

    public void updateProduct(Product product) { productRepository.update(product); }

    public List<Product> listProduct() { return productRepository.getAll(); }

    // BU METHODU SILMEYINIZ YOKSA TESTLER CALISMAZ
    public boolean deleteProduct(long id) {
        try {
            this.productRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
