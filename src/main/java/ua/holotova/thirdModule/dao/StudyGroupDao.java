package ua.holotova.thirdModule.dao;

import ua.holotova.thirdModule.model.StudyGroup;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudyGroupDao extends AbstractDao<StudyGroup> {
    @Override
    protected void init() {
        aClass = StudyGroup.class;
    }

    public List<StudyGroup> getGroupByNamePart(String namePart) {
        final CriteriaBuilder criteriaBuilder = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<StudyGroup> query = criteriaBuilder.createQuery(StudyGroup.class);
        final Root<StudyGroup> root = query.from(StudyGroup.class);
        query.select(root).where(criteriaBuilder.like(root.get("name"), "%" + namePart + "%"));
        return ENTITY_MANAGER.createQuery(query).getResultList();
    }

    public List<Object[]> countStudentsInGroups() {
        List<Object[]> resultList = ENTITY_MANAGER.createQuery(
                        "SELECT stg.name, count(l.id) " +
                                "FROM StudyGroup stg JOIN stg.learners l " +
                                "GROUP BY stg.name", Object[].class)
                .getResultList();
        return resultList;
    }

    public List<Object[]> getAverageMarkInGroups() {
        List<Object[]> resultList = ENTITY_MANAGER.createQuery(
                        "SELECT stg.name, avg(m.value) " +
                                "FROM StudyGroup stg JOIN stg.learners l JOIN l.marks m " +
                                "GROUP BY stg.name", Object[].class)
                .getResultList();
        return resultList;
    }
}



