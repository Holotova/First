package ua.holotova.hw24.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateSessionFactoryUtil {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
