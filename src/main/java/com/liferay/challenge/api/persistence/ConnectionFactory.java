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
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
