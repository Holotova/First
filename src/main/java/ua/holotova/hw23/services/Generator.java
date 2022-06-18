package ua.holotova.hw23.services;

import lombok.SneakyThrows;
import ua.holotova.hw23.model.Device;
import ua.holotova.hw23.model.Factory;
import ua.holotova.hw23.model.Mapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Generator {
    private static String samsungFactoryId = String.valueOf(UUID.randomUUID());
    private static String appleFactoryId = String.valueOf(UUID.randomUUID());
    private static String lgFactoryId = String.valueOf(UUID.randomUUID());
    private static String philipsFactoryId = String.valueOf(UUID.randomUUID());
    static final List<Factory> factories = factoryGenerator();
    static final List<Device> devices = deviceGenerator();

    public static List<Factory> factoryGenerator() {
        List<Factory> factoryList = new ArrayList<>();
        factoryList.add(new Factory(samsungFactoryId, "Samsung", "Korea"));
        factoryList.add(new Factory(appleFactoryId, "Apple", "USA"));
        factoryList.add(new Factory(lgFactoryId, "LG", "China"));
        factoryList.add(new Factory(philipsFactoryId, "Philips", "Poland"));
        return factoryList;
    }

    public static List<Device> deviceGenerator() {
        List<Device> deviceList = new ArrayList<>();
        deviceList.add(new Device(1, "TV", "F-750Y", 15000, LocalDate.now(), "Screen diagonal 43 inches", true, samsungFactoryId));
        deviceList.add(new Device(2, "Phone", "Galaxy", 18000, LocalDate.now(), "Operating System Android", true, samsungFactoryId));
        deviceList.add(new Device(3, "Phone", "XR", 15000, LocalDate.now(), "Operating System IOS", true, appleFactoryId));
        deviceList.add(new Device(4, "Notebook", "MacBook Pro 16", 130000, LocalDate.now(), " Liquid Retina XDR screen", true, appleFactoryId));
        deviceList.add(new Device(5, "Headphones", "Airpods Pro", 6000, LocalDate.now(), "Wireless Charging Case", true, appleFactoryId));
        deviceList.add(new Device(6, "TV", "LG-370F", 12000, LocalDate.now(), "Screen diagonal 32 inches", false, lgFactoryId));
        deviceList.add(new Device(7, "Phone", "V60", 12000, LocalDate.now(), "Operating System Android", true, lgFactoryId));
        deviceList.add(new Device(8, "Watch", "LG Watch Sport", 8000, LocalDate.now(), "P-OLED display", false, lgFactoryId));
        deviceList.add(new Device(9, "TV", "PH-4000", 22000, LocalDate.now(), "Screen diagonal 63 inches", true, philipsFactoryId));
        deviceList.add(new Device(10, "Monitor", "328E1CA/00", 17000, LocalDate.now(), "diagonal 31.5 inches", true, philipsFactoryId));
        return deviceList;
    }

    @SneakyThrows
    public static void saveFactoryToDataBase() {
        String sql = "insert into factory " +
                "(Factory_ID, Name, Country)" +
                "values (?, ?, ?)";
        for (Factory factory : factories) {
            final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
            statement.setString(1, factory.getFactoryId());
            statement.setString(2, factory.getName());
            statement.setString(3, factory.getCountry());
            statement.executeUpdate();
            statement.close();
        }
    }

    @SneakyThrows
    public static void saveDeviceToDataBase() {
        String sql = "insert into device " +
                "(ID, Type, Model, Price, Date_of_creation, Description, Availability, Factory_ID)" +
                "values (?, ?, ?, ?, ?, ?, ?, ?)";
        for (Device device : devices) {
            final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
            statement.setInt(1, device.getId());
            statement.setString(2, device.getType());
            statement.setString(3, device.getModel());
            statement.setInt(4, device.getPrice());
            statement.setDate(5, Date.valueOf(device.getDate()));
            statement.setString(6, device.getDescription());
            statement.setBoolean(7, device.getAvailability());
            statement.setString(8, device.getFactoryId());
            statement.executeUpdate();
            statement.close();
        }
    }

    @SneakyThrows
    public static Device getDeviceInfoByID(Integer id) {
        final String sql = "select * from device where id = ?";
        final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
        statement.setInt(1, id);
        final ResultSet resultSet = statement.executeQuery();
        Optional<Device> resultDevice = resultSet.next() ? Optional.of(Mapper.mapToObjectDevice(resultSet)) : Optional.empty();
        return resultDevice.get();

    }

    @SneakyThrows
    public static Factory getFactoryInfoByDeviceID(Integer id) {
        final String sql = "select * from factory where Factory_ID = ?";
        final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
        statement.setString(1, getDeviceInfoByID(id).getFactoryId());
        final ResultSet resultSet = statement.executeQuery();
        Optional<Factory> resultFactory = resultSet.next() ? Optional.of(Mapper.mapToObjectFactory(resultSet)) : Optional.empty();
        return resultFactory.get();
    }

    @SneakyThrows
    public static void changeDataOfDevice(Integer id) {
        final String sql = "UPDATE device SET Model = ?, Price = ?, Availability = ?, Description =? where id = ?";
        Device deviceFromDb = getDeviceInfoByID(id);
        deviceFromDb.setModel("Galaxy NEW NEW NEW!!!");
        deviceFromDb.setPrice(21000);
        deviceFromDb.setAvailability(false);
        deviceFromDb.setDescription("Will be soon available...");
        final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
        statement.setString(1, deviceFromDb.getModel());
        statement.setInt(2, deviceFromDb.getPrice());
        statement.setBoolean(3, deviceFromDb.getAvailability());
        statement.setString(4, deviceFromDb.getDescription());
        statement.setInt(5, id);
        statement.executeUpdate();
        statement.close();
        System.out.println("Data was changed...");
    }

    @SneakyThrows
    public static void deleteDeviceById(Integer id) {
        final String sql = "DELETE FROM device where id = ?";
        final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        System.out.println("Device was deleted...");
    }

    @SneakyThrows
    public static void getDevicesByFactory(String factoryName) {
        final String sql = "SELECT * FROM factory INNER JOIN device ON device.Factory_ID = factory.Factory_ID where Name = ?";
        final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
        statement.setString(1, factoryName);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.print(resultSet.getString("Name") + " - ");
            System.out.print("Device ID: " + resultSet.getInt("ID") + ", ");
            System.out.print("Type: " + resultSet.getString("Type") + ", ");
            System.out.print("Model: " + resultSet.getString("Model") + ", ");
            System.out.print("Price: " + resultSet.getInt("Price") + ", ");
            System.out.print("Date of creation: " + resultSet.getDate("Date_of_creation").toLocalDate() + ", ");
            System.out.print("Description: " + resultSet.getString("Description") + ", ");
            System.out.println("Availability in store: " + resultSet.getBoolean("Availability") + ".");
        }
    }

    @SneakyThrows
    public static void getDevicesGroupingByFactory() {
        final String sql = "SELECT factory.Name, COUNT(device.ID) AS cnt, " +
                "SUM(Price) AS sm FROM factory " +
                "INNER JOIN device USING (Factory_ID) " +
                "GROUP BY factory.Name";
        final PreparedStatement statement = CreateTables.getPreparedStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.printf(String.format("Factory: %s, ", resultSet.getString("Name")));
            System.out.printf(String.format("Number of devices: %d, ", resultSet.getInt("cnt")));
            System.out.printf(String.format("Total amount of devices: %d \n", resultSet.getInt("sm")));
        }
    }
}









