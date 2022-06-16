package ua.holotova.hw26;

import ua.holotova.hw26.service.CustomerService;
import ua.holotova.hw26.service.OrderService;
import ua.holotova.hw26.service.ProductService;

public class Main {
    private static final ProductService productService = new ProductService();
    private static final CustomerService customerService = new CustomerService();
    private static final OrderService orderService = new OrderService();

    public static void main(String[] args) {
        productService.createProducts();
        System.out.println("Products created...");
        System.out.println("_________________________");
        customerService.createCustomers();
        System.out.println("Customers created...");
        System.out.println("_________________________");
        orderService.createOrders();
        System.out.println("Orders created...");
        System.out.println("_________________________");
        orderService.bindOrders();
        System.out.println("Bindered...");
        System.out.println("_________________________");
        productService.printAllProducts();
        System.out.println("_________________________");
        orderService.printOrdersByCustomer("Vilson");
        System.out.println("_________________________");
        customerService.printCustomersByAge(20, 40);
        System.out.println("_________________________");
        customerService.printCustomersUnder18NewStatus("underage");
        System.out.println("_________________________");
        orderService.deleteOrder(5);
        System.out.println("_________________________");
        orderService.printOrdersWithProductsMoreThan(2);
        System.out.println("_________________________");
        orderService.printOrdersWithNewPrice("TV", 777777);
        System.out.println("_________________________");
    }
}
