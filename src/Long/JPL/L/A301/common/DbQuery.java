package JPL.L.A301.common;

import java.sql.*;

public class DbQuery {
    private static Connection connection;  // Add this field to store the connection
    public static Connection getConnection() {
        return ConfigDb.connection;
    }
    public static void openConnection() {
        try {
            Class.forName(ConfigDb.JDBC_DRIVER);
            ConfigDb.connection = DriverManager.getConnection(ConfigDb.JDBC_URL, ConfigDb.USERNAME, ConfigDb.PASSWORD);
            //System.out.println("Connected successfully to the database.");
        } catch (SQLException e) {
            System.err.println("Connection error to the database: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Hàm để đóng kết nốid
    public static void closeConnection() {
        if (ConfigDb.connection != null) {
            try {
                ConfigDb.connection.close();
                // System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    // Hàm để thực hiện truy vấn SELECT
    public static ResultSet executeSelectQuery(String query, Object... params) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = ConfigDb.connection.prepareStatement(query);
            // Đặt các tham số cho truy vấn (nếu có)
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.err.println("Lỗi khi thực hiện truy vấn SELECT: " + e.getMessage());
        }
        return resultSet;
    }

    // Hàm để thực hiện truy vấn UPDATE hoặc INSERT
    public static int executeUpdateQuery(String query, Object... params) {
        int rowsAffected = 0;
        try {
            PreparedStatement preparedStatement = ConfigDb.connection.prepareStatement(query);
            // Đặt các tham số cho truy vấn (nếu có)
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi khi thực hiện truy vấn UPDATE hoặc INSERT: " + e.getMessage());
        }
        return rowsAffected;
    }
}
