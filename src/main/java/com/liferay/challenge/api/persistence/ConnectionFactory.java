package com.liferay.challenge.api.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void close(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement statement){
        close(connection);
        try {
            if (statement != null){
                statement.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
}
