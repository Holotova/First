package ua.holotova.hw23.model;

import lombok.SneakyThrows;

import java.sql.ResultSet;

public class Mapper {
    @SneakyThrows
    public static Device mapToObjectDevice(final ResultSet resultSet) {
        final Device device = new Device();
        device.setId(resultSet.getInt("ID"));
        device.setType(resultSet.getString("Type"));
        device.setModel(resultSet.getString("Model"));
        device.setPrice(resultSet.getInt("Price"));
        device.setDate(resultSet.getDate("Date_of_creation").toLocalDate());
        device.setDescription(resultSet.getString("Description"));
        device.setAvailability(resultSet.getBoolean("Availability"));
        device.setFactoryId(resultSet.getString("Factory_ID"));
        return device;
    }

    @SneakyThrows
    public static Factory mapToObjectFactory(final ResultSet resultSet) {
        final Factory factory = new Factory();
        factory.setFactoryId(resultSet.getString("Factory_ID"));
        factory.setName(resultSet.getString("Name"));
        factory.setCountry(resultSet.getString("Country"));
        return factory;
    }

}
