package com.liferay.challenge.api.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: Bruno Queiroz.
 */
public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/product";
        String user = "root";
        String password = "12345Eja!";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established with MySql 8.0 " + connection);
            return connection;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
