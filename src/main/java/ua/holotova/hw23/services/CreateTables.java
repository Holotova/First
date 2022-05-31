package ua.holotova.hw23.services;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateTables {
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "root";

    @SneakyThrows
    public static void createSqlTables() {
        String sqlTableDevice = "CREATE TABLE DEVICE " +
                "(ID Integer not Null," +
                " Type varchar(250) not Null," +
                " Model varchar(250) not Null," +
                " Price Integer not Null," +
                " Date_of_creation date NOT NULL, " +
                " Description text not Null," +
                " Availability boolean not Null," +
                " Factory_ID varchar(250) not Null," +
                " PRIMARY KEY (ID)," +
                " FOREIGN KEY (Factory_ID) REFERENCES FACTORY(Factory_ID))";
        String sqlTableFactory = "CREATE TABLE FACTORY " +
                "(Factory_ID varchar(250) not Null," +
                " Name varchar(250) not Null," +
                " Country varchar(250) not Null," +
                " PRIMARY KEY (Factory_ID))";
        Statement statement = getStatement();
        statement.executeUpdate(sqlTableFactory);
        statement.executeUpdate(sqlTableDevice);
        System.out.println("Tables created in database");
    }

    @SneakyThrows
    private static Connection getMyConnection() {
        return DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
    }

    @SneakyThrows
    private static Statement getStatement() {
        Connection connection = getMyConnection();
        return connection.createStatement();
    }

    @SneakyThrows
    public static PreparedStatement getPreparedStatement(String sql) {
        Connection connection = getMyConnection();
        return connection.prepareStatement(sql);
    }

}
