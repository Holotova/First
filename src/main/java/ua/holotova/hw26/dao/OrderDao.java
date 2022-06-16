package ua.holotova.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.holotova.hw26.model.Order;

import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class OrderDao extends AbstractDao<Order> {

    private static final String COLLECTION_NAME = "orders";

    public OrderDao(MongoDatabase db) {
        super(db, COLLECTION_NAME);
    }

    public List<Order> findAll() {
        return super.findAll(Order.class);
    }

    public void updateOrders(String orderId, List<String> products, String customerId) {
        final Document filter = new Document();
        filter.append("id", orderId);

        final Document update = new Document();
        update.append("products", products);
        update.append("customerId", customerId);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }

    public void deleteOrder(String orderId) {
        final Document filter = new Document();
        filter.append("id", orderId);
        collection.deleteOne(filter);
    }

    public List<Order> getOrdersWithProductsMoreTwo(Integer numberOfProducts) {
        String query = "this.products.length > " + numberOfProducts;
        return super.findAll(Order.class, and(exists("products"), where(query)));
    }

    public List<Order> getOrdersByCustomer(String customerId) {
        return super.findAll(Order.class, eq("customerId", customerId));
    }

}
