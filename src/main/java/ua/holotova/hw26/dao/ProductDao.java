package ua.holotova.hw26.dao;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.holotova.hw26.model.Product;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static ua.holotova.hw26.service.ProductService.PRODUCT_DAO;

public class ProductDao extends AbstractDao<Product> {

    private static final String COLLECTION_NAME = "products";

    public ProductDao(MongoDatabase db) {
        super(db, COLLECTION_NAME);
    }

    public List<Product> findAll() {
        return super.findAll(Product.class);
    }

    public void updatePrice(String productName, Integer price) {
        final Document filter = new Document();
        filter.append("name", productName);

        final Document update = new Document();
        update.append("price", price);

        final Document doc = new Document();
        doc.append("$set", update);

        collection.updateOne(filter, doc);
    }

    public void changeProductPrice(String productName, Integer price) {
        List<Product> products = super.findAll(Product.class, eq("name", productName));
        PRODUCT_DAO.updatePrice(products.get(0).getName(), price);
    }
}
