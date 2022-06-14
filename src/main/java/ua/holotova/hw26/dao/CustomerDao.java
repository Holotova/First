package ua.holotova.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.holotova.hw26.model.Customer;

import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static ua.holotova.hw26.service.CustomerService.CUSTOMER_DAO;

public class CustomerDao extends AbstractDao<Customer> {

    private static final String COLLECTION_NAME = "customers";

    public CustomerDao(MongoDatabase db) {

        super(db, COLLECTION_NAME);
    }

    public List<Customer> findAll() {

        return super.findAll(Customer.class);
    }

    public void updateCustomer(String customerId, List<String> orders) {
        final Document filter = new Document();
        filter.append("id", customerId);

        final Document update = new Document();
        update.append("orders", orders);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }

    public void updateCustomerStatus(String customerId, String status) {
        final Document filter = new Document();
        filter.append("id", customerId);

        final Document update = new Document();
        update.append("status", status);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }

    public List<Customer> findCustomersByAge(Integer minAge, Integer maxAge) {
        return super.findAll(Customer.class, and(gte("age", minAge), lte("age", maxAge)));
    }

    public void changeStatusLess18(String status) {
        List<Customer> youngCustomers = super.findAll(Customer.class, lte("age", 18));
        for (Customer youngCustomer : youngCustomers) {
            CUSTOMER_DAO.updateCustomerStatus(youngCustomer.getId(), status);
        }
    }
}
