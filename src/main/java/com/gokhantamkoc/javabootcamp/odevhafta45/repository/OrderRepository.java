package com.gokhantamkoc.javabootcamp.odevhafta45.repository;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Order;
import com.gokhantamkoc.javabootcamp.odevhafta45.model.OrderDetail;
import com.gokhantamkoc.javabootcamp.odevhafta45.model.Owner;
import com.gokhantamkoc.javabootcamp.odevhafta45.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository {

    private DatabaseConnection databaseConnection;
    private OwnerRepository ownerRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    @Autowired
    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll() {
        final String SQL =
                "SELECT id, status, requester_id, bidder_id, requester_address, bidder_address FROM public.order";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String status = rs.getString("status");
                Owner requester = this.ownerRepository.get(rs.getLong("requester_id"));
                Owner bidder = this.ownerRepository.get(rs.getLong("bidder_id"));
                String requesterAddress = rs.getString("requester_address");
                String bidderAddress = rs.getString("bidder_address");
                orders.add(
                    new Order(
                        id,
                        status,
                        requester,
                        bidder,
                        requesterAddress,
                        bidderAddress
                    )
                );
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return orders;
    }

    public Order get(long id) {
        final String SQL = "SELECT * FROM public.order where id = ? limit 1;";
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Order(
                    rs.getLong("id"),
                    rs.getString("status"),
                    this.ownerRepository.get(rs.getLong("requester_id")),
                    this.ownerRepository.get(rs.getLong("bidder_id")),
                    rs.getString("requester_address"),
                    rs.getString("bidder_address")
                );
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<OrderDetail> getOrderDetails(long orderId) {
        // BU METHODU 2. GOREV ICIN DOLDURUNUZ
    }

    public void save(Order order) throws RuntimeException {
        final String SQL = "INSERT INTO public.owner(id, status, requester_id, bidder_id, requester_address, bidder_address) values(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
            preparedStatement.setLong(1, order.getId());
            preparedStatement.setString(2, "IN_PROGRESS");
            preparedStatement.setLong(3, order.getRequester().getId());
            preparedStatement.setLong(4, order.getBidder().getId());
            preparedStatement.setString(5, order.getRequesterAddress());
            preparedStatement.setString(6, order.getBidderAddress());
            int affectedRows = preparedStatement.executeUpdate(SQL);
            if (affectedRows <= 0) {
                throw new RuntimeException(String.format("Could not save order %s!", order));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void update(Order order) throws RuntimeException {
        Order foundOrder = this.get(order.getId());
        if (foundOrder != null) {
            final String SQL = "UPDATE public.order set status = ?, requester_id = ?, bidder_id = ?, requester_address = ?, bidder_address = ? where id = ?";
            try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
                preparedStatement.setString(1, order.getStatus());
                preparedStatement.setLong(2, order.getRequester().getId());
                preparedStatement.setLong(3, order.getBidder().getId());
                preparedStatement.setString(4, order.getRequesterAddress());
                preparedStatement.setString(5, order.getBidderAddress());
                preparedStatement.setLong(6, order.getId());
                int affectedRows = preparedStatement.executeUpdate(SQL);
                if (affectedRows <= 0) {
                    throw new RuntimeException(String.format("Could not update order %s!", order));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

}
