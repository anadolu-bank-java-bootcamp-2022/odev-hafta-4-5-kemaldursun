package com.gokhantamkoc.javabootcamp.odevhafta45.util.consoleresponsehandler;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Order;
import com.gokhantamkoc.javabootcamp.odevhafta45.service.OrderService;

import java.util.List;

public class ListOrderConsoleResponseHandler extends ConsoleResponseHandler {

    private OrderService orderService;

    public ListOrderConsoleResponseHandler(ConsoleResponseHandler nextHandler, OrderService orderService) {
        super(nextHandler);
        this.orderService = orderService;
    }

    @Override
    public boolean handleConsoleResponse(String response) {
        if (response.equalsIgnoreCase("LO")) {
            List<Order> orderList = this.orderService.listOrders();
            for (Order order : orderList) {
                System.out.println(order);
            }
            return true;
        } else if (nextHandler != null) {
            return this.nextHandler.handleConsoleResponse(response);
        }
        return false;
    }
}
