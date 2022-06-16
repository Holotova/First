package ua.holotova.hw26.service;

import ua.holotova.hw26.dao.CustomerDao;
import ua.holotova.hw26.model.Customer;

import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.lte;
import static ua.holotova.hw26.dao.AbstractDao.DB;

public class CustomerService {

    public static final CustomerDao CUSTOMER_DAO = new CustomerDao(DB);

    public void createCustomers() {

        final Customer customer1 = new Customer("Bill", "Jonson", 37, "current");
        final Customer customer2 = new Customer("Sam", "Ramon", 65, "vip");
        final Customer customer3 = new Customer("Mary", "Bell", 17, "current");
        final Customer customer4 = new Customer("Nick", "Vilson", 15, "vip");
        final Customer customer5 = new Customer("Polly", "Perkin", 23, "current");
        CUSTOMER_DAO.insertMany(Arrays.asList(customer1, customer2, customer3, customer4, customer5));
    }

    public void printCustomersByAge(Integer minAge, Integer maxAge) {
        System.out.printf("Customers from %d to %d years:\n", minAge, maxAge);
        CUSTOMER_DAO.findCustomersByAge(minAge, maxAge).forEach(System.out::println);
    }

    public void printCustomersUnder18NewStatus(String status) {
        System.out.printf("Customers younger 18 years:\n");
        CUSTOMER_DAO.changeStatusLess18(status);
        List<Customer> youngCustomers = CUSTOMER_DAO.findAll(Customer.class, lte("age", 18));
        youngCustomers.forEach(System.out::println);
    }
}
