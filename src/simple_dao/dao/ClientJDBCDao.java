package simple_dao.dao;

import simple_dao.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao implements ClientDao {

    @Override
   public void add(Client client) {

            Connection connection = null;

            connection = getConnection();
            PreparedStatement statement;

        try {
            statement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");

            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Client> getAll() {
        List<Client> allClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM clients ");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                allClients.add(client);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return allClients;
    }

        @Override
        public Client getById(int id) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            connection = getConnection();

            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE id = ?");

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String name = rs.getString(1);
                    int age = rs.getInt(2);
                    String phone = rs.getString(3);
                    Client client = new Client();
                    client.setId(id);
                    client.setName(name);
                    client.setAge(age);
                    client.setPhone(phone);
                    return client;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null && preparedStatement != null) {

                    try {
                        connection.close();
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
    }



    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carshop", "root", "smile999");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
