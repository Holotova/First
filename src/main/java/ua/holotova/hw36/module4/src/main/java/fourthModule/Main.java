package fourthModule;

import fourthModule.model.Factory;
import fourthModule.util.HibernateFactoryUtil;

public class Main {
    private static final Factory FACTORY = new Factory();

    public static void main(String[] args) throws InterruptedException {
        HibernateFactoryUtil.init();
        FACTORY.startProduction();
    }
}

