package ua.holotova.thirdModule.dao;

import ua.holotova.thirdModule.model.EconomicUniversity;

public class EconomicUniversityDao extends AbstractDao<EconomicUniversity> {
    @Override
    protected void init() {
        aClass = EconomicUniversity.class;
    }
}
