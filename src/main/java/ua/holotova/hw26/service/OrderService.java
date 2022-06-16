package ua.holotova.hw26.service;

import ua.holotova.hw26.dao.OrderDao;
import ua.holotova.hw26.model.Customer;
import ua.holotova.hw26.model.Order;
import ua.holotova.hw26.model.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static ua.holotova.hw26.dao.AbstractDao.DB;
import static ua.holotova.hw26.service.CustomerService.CUSTOMER_DAO;
import static ua.holotova.hw26.service.ProductService.PRODUCT_DAO;

public class OrderService {

    private static final OrderDao ORDER_DAO = new OrderDao(DB);

    public void createOrders() {
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        Order order5 = new Order();
        Order order6 = new Order();
        Order order7 = new Order();
        Order order8 = new Order();
        Order order9 = new Order();
        Order order10 = new Order();

        ORDER_DAO.insertMany(Arrays.asList(order1, order2, order3, order4, order5, order6, order7,
                order8, order9, order10));
    }

    public void bindOrders() {
        List<Order> orders = ORDER_DAO.findAll();
        List<Customer> customers = CUSTOMER_DAO.findAll();
        List<Product> products = PRODUCT_DAO.findAll();

        Order or1 = orders.get(0);
        Order or2 = orders.get(1);
        Order or3 = orders.get(2);
        Order or4 = orders.get(3);
        Order or5 = orders.get(4);
        Order or6 = orders.get(5);
        Order or7 = orders.get(6);
        Order or8 = orders.get(7);
        Order or9 = orders.get(8);
        Order or10 = orders.get(9);

        Product pr1 = products.get(0);
        Product pr2 = products.get(1);
        Product pr3 = products.get(2);
        Product pr4 = products.get(3);
        Product pr5 = products.get(4);
        Product pr6 = products.get(5);
        Product pr7 = products.get(6);
        Product pr8 = products.get(7);

        Customer cust1 = customers.get(0);
        Customer cust2 = customers.get(1);
        Customer cust3 = customers.get(2);
        Customer cust4 = customers.get(3);
        Customer cust5 = customers.get(4);

        CUSTOMER_DAO.updateCustomer(cust1.getId(), Arrays.asList(or1.getId(), or7.getId(), or9.getId()));
        CUSTOMER_DAO.updateCustomer(cust2.getId(), Arrays.asList(or2.getId(), or10.getId()));
        CUSTOMER_DAO.updateCustomer(cust3.getId(), Collections.singletonList(or3.getId()));
        CUSTOMER_DAO.updateCustomer(cust4.getId(), Arrays.asList(or4.getId(), or6.getId()));
        CUSTOMER_DAO.updateCustomer(cust5.getId(), Arrays.asList(or5.getId(), or8.getId()));

        ORDER_DAO.updateOrders(or1.getId(), Arrays.asList(pr1.getId(), pr2.getId()), cust1.getId());
        ORDER_DAO.updateOrders(or2.getId(), Arrays.asList(pr3.getId(), pr4.getId(), pr5.getId()), cust2.getId());
        ORDER_DAO.updateOrders(or3.getId(), Collections.singletonList(pr6.getId()), cust3.getId());
        ORDER_DAO.updateOrders(or4.getId(), Arrays.asList(pr6.getId(), pr7.getId(), pr8.getId()), cust4.getId());
        ORDER_DAO.updateOrders(or5.getId(), Arrays.asList(pr7.getId(), pr2.getId(), pr4.getId()), cust5.getId());
        ORDER_DAO.updateOrders(or6.getId(), Arrays.asList(pr1.getId(), pr8.getId()), cust4.getId());
        ORDER_DAO.updateOrders(or7.getId(), Arrays.asList(pr1.getId(), pr2.getId(), pr4.getId()), cust1.getId());
        ORDER_DAO.updateOrders(or8.getId(), Arrays.asList(pr8.getId(), pr5.getId()), cust5.getId());
        ORDER_DAO.updateOrders(or9.getId(), Collections.singletonList(pr3.getId()), cust1.getId());
        ORDER_DAO.updateOrders(or10.getId(), Arrays.asList(pr1.getId(), pr2.getId()), cust2.getId());

    }

    public void printAllOrders() {
        ORDER_DAO.findAll().forEach(System.out::println);
    }

    public void printOrdersByCustomer(String customerLastName) {
        System.out.println("Orders of customer " + customerLastName);
        List<Customer> customers = CUSTOMER_DAO.findAll(Customer.class, eq("lastName", customerLastName));
        List<Order> orders = ORDER_DAO.getOrdersByCustomer(customers.get(0).getId());
        orders.forEach(System.out::println);
    }

    public void deleteOrder(Integer orderNumber) {
        System.out.println("Orders before removal:");
        printAllOrders();
        List<Order> orders = ORDER_DAO.findAll();
        ORDER_DAO.deleteOrder(orders.get(orderNumber - 1).getId());
        System.out.printf("Order number %d was deleted.\nOrders after removal:\n", orderNumber);
        printAllOrders();
    }

    public void printOrdersWithProductsMoreThan(Integer numberOfProducts) {
        System.out.printf("Orders with number of products more than %d:\n", numberOfProducts);
        List<Order> orders = ORDER_DAO.getOrdersWithProductsMoreTwo(numberOfProducts);
        orders.forEach(System.out::println);
    }

    public void printOrdersWithNewPrice(String productName, Integer price) {
        System.out.printf("Product with new price %d:\n", price);
        PRODUCT_DAO.changeProductPrice(productName, price);
        List<Product> productNewPrice = PRODUCT_DAO.findAll(Product.class, eq("name", productName));
        productNewPrice.forEach(System.out::println);
        System.out.println("Orders:");
        List<Order> orders = ORDER_DAO.findAll();
        orders.forEach(System.out::println);
    }
}