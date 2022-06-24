package ua.holotova.thirdModule.dao;

import ua.holotova.thirdModule.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

abstract class AbstractDao<T> {
    protected Class<T> aClass;
    protected final EntityManager ENTITY_MANAGER = HibernateFactoryUtil.getEntityManager();

    public AbstractDao() {
        init();
    }

    protected abstract void init();

    public void save(T value) {
        final EntityTransaction transaction = ENTITY_MANAGER.getTransaction();
        transaction.begin();
        ENTITY_MANAGER.persist(value);
        ENTITY_MANAGER.flush();
        transaction.commit();
    }

}
