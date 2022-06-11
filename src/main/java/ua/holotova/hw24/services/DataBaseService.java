package ua.holotova.hw24.services;

import ua.holotova.hw24.model.Device;
import ua.holotova.hw24.model.Factory;
import ua.holotova.hw24.util.HibernateSessionFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataBaseService {

    public static void createTablesByHibernate() {

        final Factory samsungFactory = new Factory("Samsung", "Korea");
        final Factory appleFactory = new Factory("Apple", "USA");
        final Factory lgFactory = new Factory("LG", "China");
        final Factory philipsFactory = new Factory("Philips", "Poland");

        final Device samsDevice1 = new Device("TV", "F-750Y", 15000, LocalDate.now(),
                "Screen diagonal 43 inches", true, samsungFactory);
        final Device samsDevice2 = new Device("Phone", "Galaxy", 18000, LocalDate.now(),
                "Operating System Android", true, samsungFactory);
        final Device appleDevice1 = new Device("Phone", "XR", 15000, LocalDate.now(),
                "Operating System IOS", true, appleFactory);
        final Device appleDevice2 = new Device("Notebook", "MacBook Pro 16", 130000, LocalDate.now(),
                " Liquid Retina XDR screen", true, appleFactory);
        final Device appleDevice3 = new Device("Headphones", "Airpods Pro", 6000, LocalDate.now(),
                "Wireless Charging Case", true, appleFactory);
        final Device lgDevice1 = new Device("TV", "LG-370F", 12000, LocalDate.now(),
                "Screen diagonal 32 inches", false, lgFactory);
        final Device lgDevice2 = new Device("Phone", "V60", 12000, LocalDate.now(),
                "Operating System Android", true, lgFactory);
        final Device lgDevice3 = new Device("Watch", "LG Watch Sport", 8000, LocalDate.now(),
                "P-OLED display", false, lgFactory);
        final Device philDevice1 = new Device("TV", "PH-4000", 22000, LocalDate.now(),
                "Screen diagonal 63 inches", true, philipsFactory);
        final Device philDevice2 = new Device("Monitor", "328E1CA/00", 17000, LocalDate.now(),
                "diagonal 31.5 inches", true, philipsFactory);

        Set<Device> deviceSetSamsung = new HashSet<>();
        deviceSetSamsung.add(samsDevice1);
        deviceSetSamsung.add(samsDevice2);

        Set<Device> deviceSetApple = new HashSet<>();
        deviceSetApple.add(appleDevice1);
        deviceSetApple.add(appleDevice2);
        deviceSetApple.add(appleDevice3);

        Set<Device> deviceSetLg = new HashSet<>();
        deviceSetLg.add(lgDevice1);
        deviceSetLg.add(lgDevice2);
        deviceSetLg.add(lgDevice3);

        Set<Device> deviceSetPhilips = new HashSet<>();
        deviceSetPhilips.add(philDevice1);
        deviceSetPhilips.add(philDevice2);

        samsungFactory.setDevices(deviceSetSamsung);
        appleFactory.setDevices(deviceSetApple);
        lgFactory.setDevices(deviceSetLg);
        philipsFactory.setDevices(deviceSetPhilips);

        final EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(samsungFactory);
        entityManager.persist(appleFactory);
        entityManager.persist(lgFactory);
        entityManager.persist(philipsFactory);
        entityManager.persist(samsDevice1);
        entityManager.persist(samsDevice2);
        entityManager.persist(appleDevice1);
        entityManager.persist(appleDevice2);
        entityManager.persist(appleDevice3);
        entityManager.persist(lgDevice1);
        entityManager.persist(lgDevice2);
        entityManager.persist(lgDevice3);
        entityManager.persist(philDevice1);
        entityManager.persist(philDevice2);
        entityManager.getTransaction().commit();
        System.out.println("Tables are created in DB");
    }

    public static void getDeviceInfoById(Integer id) {
        final EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Device> criteriaQuery = criteriaBuilder.createQuery(Device.class);
        Root<Device> root = criteriaQuery.from(Device.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));
        Device requiredDevice = entityManager.createQuery(criteriaQuery)
                .getSingleResult();
        System.out.printf("Information about device number %d: %s. %s \n",
                id, requiredDevice.toString(), requiredDevice.getFactory().toString());
    }

    public static void changeDataOfDevice(Integer id) {
        final EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Device> update = criteriaBuilder.createCriteriaUpdate(Device.class);
        Root<Device> root = update.from(Device.class);
        update.set("price", 30000);
        update.set("model", "Galaxy NEW NEW NEW!!!");
        update.set("availability", false);
        update.set("description", "Will be soon available...");
        update.where(criteriaBuilder.equal(root.get("id"), id));
        entityManager.createQuery(update).executeUpdate();
        entityManager.getTransaction().commit();

        System.out.printf("Information about device number %d updated \n", id);
    }

    public static void deleteDevice(Integer id) {
        final EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Device> del = criteriaBuilder.createCriteriaDelete(Device.class);
        Root<Device> root = del.from(Device.class);
        del.where(criteriaBuilder.equal(root.get("id"), id));
        entityManager.createQuery(del).executeUpdate();
        entityManager.getTransaction().commit();

        System.out.printf("Device number %d deleted \n", id);
    }

    public static void getDevicesByFactory(String factoryName) {
        final EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Factory> query = criteriaBuilder.createQuery(Factory.class);
        Root<Factory> root = query.from(Factory.class);
        query.select(root).where(criteriaBuilder.equal(root.get("name"), factoryName));
        System.out.printf("Factory %s:\n", factoryName);
        entityManager.createQuery(query)
                .getSingleResult()
                .getDevices()
                .forEach(System.out::println);
    }

    public static void getDevicesGroupingByFactory() {
        final EntityManager entityManager = HibernateSessionFactoryUtil.getEntityManager();
        List<Object[]> resultList = entityManager.createQuery(
                        "select f.name, count( d.id ), sum( d.price ) " +
                                "from Device d " +
                                "join d.factory f " +
                                "group by f.name", Object[].class)
                .getResultList();

        for (Object[] objects : resultList) {
            String factoryName = objects[0].toString();
            Number devices = (Number) objects[1];
            Number totalPrice = (Number) objects[2];
            System.out.printf("Factory: %s, number of devices: %d, total price of devices: %d. \n",
                    factoryName, devices, totalPrice);
        }
    }
}
