package ua.holotova.hw24;

import ua.holotova.hw24.services.DataBaseService;

public class Main {
    public static void main(String[] args) {
        DataBaseService.createTablesByHibernate();
        System.out.println("_______________");
        DataBaseService.getDeviceInfoById(2);
        System.out.println("_______________");
        DataBaseService.changeDataOfDevice(2);
        System.out.println("_______________");
        DataBaseService.deleteDevice(7);
        System.out.println("_______________");
        DataBaseService.getDevicesByFactory("LG");
        System.out.println("_______________");
        DataBaseService.getDevicesGroupingByFactory();
    }
}
