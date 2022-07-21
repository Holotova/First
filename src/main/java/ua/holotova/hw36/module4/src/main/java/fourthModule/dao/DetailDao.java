package fourthModule.dao;

import fourthModule.model.Detail;

public class DetailDao extends AbstractDao<Detail> {
    @Override
    protected void init() {
        aClass = Detail.class;
    }

    public int getSumOfDetails() {
        return (int) getAll().stream().count();
    }

    public int getBrokenDetails() {
        Number res = (Number) ENTITY_MANAGER.createNativeQuery
                ("select sum(brokenschema) from Detail").getSingleResult();
        return res.intValue();

    }

    public int getFuel() {
        Number res = (Number) ENTITY_MANAGER.createNativeQuery
                ("select sum(fuel) from Detail").getSingleResult();
        return res.intValue();
    }
}
