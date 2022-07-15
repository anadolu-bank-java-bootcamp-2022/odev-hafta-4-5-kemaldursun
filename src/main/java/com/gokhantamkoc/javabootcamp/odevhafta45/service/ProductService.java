package com.gokhantamkoc.javabootcamp.odevhafta45.service;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Product;
import com.gokhantamkoc.javabootcamp.odevhafta45.repository.ProductRepository;
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

    public void createProduct(Product newProduct) {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

    public Product getProduct(long id) {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

    public void updateProduct(Product product) {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

    public List<Product> listProduct() {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

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
