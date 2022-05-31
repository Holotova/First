package ua.holotova.hw23;

import ua.holotova.hw23.services.CreateTables;
import ua.holotova.hw23.services.Generator;

public class Main {

    public static void main(String[] args) {
        CreateTables.createSqlTables();
        Generator.saveFactoryToDataBase();
        Generator.saveDeviceToDataBase();
        System.out.println(Generator.getDeviceInfoByID(2) + " " + Generator.getFactoryInfoByDeviceID(2));
        Generator.changeDataOfDevice(2);
        Generator.deleteDeviceById(4);
        Generator.getDevicesByFactory("LG");
        System.out.println("__________________________________");
        Generator.getDevicesGroupingByFactory();
    }
}
