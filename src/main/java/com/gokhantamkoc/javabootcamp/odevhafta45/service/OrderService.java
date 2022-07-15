package com.gokhantamkoc.javabootcamp.odevhafta45.service;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Order;
import com.gokhantamkoc.javabootcamp.odevhafta45.model.OrderDetail;
import com.gokhantamkoc.javabootcamp.odevhafta45.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        this.orderRepository.save(order);
    }

    public Order getOrder(long id) {
        return this.orderRepository.get(id);
    }

    public void updateOrder(Order order) {
        this.orderRepository.update(order);
    }

    public List<Order> listOrders() {
        return this.orderRepository.getAll();
    }

    public List<OrderDetail> getOrderDetails(long orderId) {
        return this.orderRepository.getOrderDetails(orderId);
    }
}
