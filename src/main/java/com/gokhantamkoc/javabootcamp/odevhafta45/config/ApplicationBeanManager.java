package com.gokhantamkoc.javabootcamp.odevhafta45.config;

import com.gokhantamkoc.javabootcamp.odevhafta45.service.OrderService;
import com.gokhantamkoc.javabootcamp.odevhafta45.service.ProductService;
import com.gokhantamkoc.javabootcamp.odevhafta45.util.consoleresponsehandler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanManager {

    OrderService orderService;

    ProductService productService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Bean
    public ConsoleResponseHandler consoleResponseHandler() {
        ConsoleResponseHandler exitConsoleResponseHandler = new ExitConsoleResponseHandler(null);
        ConsoleResponseHandler showOrderDetailConsoleResponseHandler = new ShowOrderDetailConsoleResponseHandler(
                exitConsoleResponseHandler, orderService
        );
        ConsoleResponseHandler listOrderConsoleResponseHandler = new ListOrderConsoleResponseHandler(
                showOrderDetailConsoleResponseHandler, orderService
        );
        return new ListProductResponseHandler(
                listOrderConsoleResponseHandler, productService
        );
    }
}
