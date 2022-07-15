package com.gokhantamkoc.javabootcamp.odevhafta45.repository;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Product;
import com.gokhantamkoc.javabootcamp.odevhafta45.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
public class ProductRepository {

    DatabaseConnection databaseConnection;

    @Autowired
    public void setDatabaseConnection(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<Product> getAll() {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

    public Product get(long id) {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

    public void save(Product product) throws RuntimeException {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

    public void update(Product product) throws RuntimeException {
        // BU METHODU 1. GOREV ICIN DOLDURUNUZ
    }

    // BU METHODU SILMEYINIZ YOKSA TESTLER CALISMAZ
    public void delete(long id) throws RuntimeException {
        Product foundProduct = this.get(id);
        if (foundProduct != null) {
            final String SQL = "delete from public.product where id = ?";
            try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
                preparedStatement.setLong(1, id);
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows <= 0) {
                    throw new RuntimeException(String.format("Could not delete product with id %d!", id));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }
}
