package ua.holotova.thirdModule.dao;

import ua.holotova.thirdModule.model.Learner;

import java.util.List;

public class LearnerDao extends AbstractDao<Learner> {
    @Override
    protected void init() {
        aClass = Learner.class;
    }

    public List<Object[]> getLearnersWithAdvancementMore(Integer advancementRateLimit) {
        List<Object[]> resultList = ENTITY_MANAGER.createQuery(
                        "SELECT l.lastName, l.firstName, avg(m.value) " +
                                "FROM Learner l " +
                                "JOIN l.marks m " +
                                "GROUP BY l.lastName, l.firstName " +
                                "HAVING avg(m.value) > " + advancementRateLimit + "", Object[].class)
                .getResultList();
        return resultList;
    }
}
