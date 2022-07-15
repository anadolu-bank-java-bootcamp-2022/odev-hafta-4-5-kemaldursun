package com.gokhantamkoc.javabootcamp.odevhafta45.repository;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Owner;
import com.gokhantamkoc.javabootcamp.odevhafta45.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class OwnerRepository {

    private DatabaseConnection databaseConnection;

    @Autowired
    public OwnerRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<Owner> getAll() {
        final String SQL = "SELECT id, full_name, email FROM public.owner";
        List<Owner> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("full_name");
                String email = rs.getString("email");
                orders.add(
                    new Owner(
                        id,
                        name,
                        email
                    )
                );
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return orders;
    }

    public Owner get(long id) {
        final String SQL = "SELECT * FROM public.owner where id = ? limit 1;";
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Owner(
                    rs.getLong("id"),
                    rs.getString("full_name"),
                    rs.getString("email")
                );
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void save(Owner owner) throws RuntimeException {
        final String SQL = "INSERT INTO public.owner(id, full_name, email) values(?, ?, ?)";
        try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
            preparedStatement.setLong(1, owner.getId());
            preparedStatement.setString(2, owner.getFullName());
            preparedStatement.setString(3, owner.getEmail());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows <= 0) {
                throw new RuntimeException(String.format("Could not save owner %s!", owner.getFullName()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void update(Owner owner) throws RuntimeException {
        Owner foundOwner = this.get(owner.getId());
        if (foundOwner != null) {
            final String SQL = "UPDATE public.owner set full_name = ?, email = ? where id = ?";
            try (PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(SQL)) {
                preparedStatement.setString(1, owner.getFullName());
                preparedStatement.setString(2, owner.getEmail());
                preparedStatement.setLong(3, owner.getId());
                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows <= 0) {
                    throw new RuntimeException(String.format("Could not update owner %s!", owner.getFullName()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex.getMessage());
            }
        }
    }
}
