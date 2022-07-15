package com.gokhantamkoc.javabootcamp.odevhafta45.util.consoleresponsehandler;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Order;
import com.gokhantamkoc.javabootcamp.odevhafta45.model.OrderDetail;
import com.gokhantamkoc.javabootcamp.odevhafta45.service.OrderService;

import java.util.List;
import java.util.Scanner;

public class ShowOrderDetailConsoleResponseHandler extends ConsoleResponseHandler {

    final Scanner keyboardInput = new Scanner(System.in);

    private OrderService orderService;

    public ShowOrderDetailConsoleResponseHandler(ConsoleResponseHandler nextHandler, OrderService orderService) {
        super(nextHandler);
        this.orderService = orderService;
    }

    @Override
    public boolean handleConsoleResponse(String response) {
        if (response.equalsIgnoreCase("SOD")) {
            System.out.println("Which order? (1, 2, ...)");
            long orderId = this.getOrderIdFromUser();
            Order order = orderService.getOrder(orderId);
            System.out.println(order);
            System.out.println("========= DETAILS =========");
            List<OrderDetail> orderDetails = this.orderService.getOrderDetails(orderId);
            for (OrderDetail orderDetail : orderDetails) {
                System.out.println(orderDetail);
            }
            return true;
        } else if (nextHandler != null) {
            return this.nextHandler.handleConsoleResponse(response);
        }
        return false;
    }

    private long getOrderIdFromUser() {
        return keyboardInput.nextLong();
    }
}
