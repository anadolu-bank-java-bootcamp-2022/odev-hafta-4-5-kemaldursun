package com.gokhantamkoc.javabootcamp.odevhafta45.util.consoleresponsehandler;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Product;
import com.gokhantamkoc.javabootcamp.odevhafta45.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListProductResponseHandler extends ConsoleResponseHandler {

    private ProductService productService;

    public ListProductResponseHandler(ConsoleResponseHandler nextHandler, ProductService productService) {
        super(nextHandler);
        this.productService = productService;
    }

    @Override
    public boolean handleConsoleResponse(String response) {
        if (response.equalsIgnoreCase("LP")) {
            List<Product> productList = this.productService.listProduct();
            for (Product product : productList) {
                System.out.println(product);
            }
            return true;
        } else if (nextHandler != null) {
            return this.nextHandler.handleConsoleResponse(response);
        }
        return false;
    }
}
