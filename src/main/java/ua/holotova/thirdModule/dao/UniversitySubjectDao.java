package ua.holotova.thirdModule.dao;

import ua.holotova.thirdModule.model.UniversitySubject;

import java.util.List;

public class UniversitySubjectDao extends AbstractDao<UniversitySubject> {

    private static final String QUERY = "SELECT s.name, AVG(m.value) as av " +
            "FROM UniversitySubject as s " +
            "JOIN mark as m " +
            "ON s.id = m.subject_id " +
            "GROUP BY s.name " +
            "ORDER BY AVG(m.value)";

    @Override
    protected void init() {

        aClass = UniversitySubject.class;
    }

    public List<Object[]> getWorstPercentageSubject() {

        return ENTITY_MANAGER.createNativeQuery(QUERY + "limit 1").getResultList();
    }

    public List<Object[]> getBestPercentageSubject() {

        return ENTITY_MANAGER.createNativeQuery(QUERY + " desc limit 1").getResultList();
    }


}




