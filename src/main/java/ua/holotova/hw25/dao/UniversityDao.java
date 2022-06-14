package ua.holotova.hw25.dao;

import ua.holotova.hw25.config.HibernateFactoryUtil;
import ua.holotova.hw25.model.University;

import javax.persistence.EntityManager;
import java.util.List;

public class UniversityDao extends AbstractDao<University> {
    @Override
    protected void init() {
        aClass = University.class;
    }

    public List<Object[]> getInfrastructure() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT u.name as uName, ug.name as ugName, " +
                        "c.name as curName, s.name as stName " +
                        "FROM student s JOIN universitygroup_student ugs ON s.id = ugs.student_id " +
                        "JOIN universitygroup ug ON ugs.universitygroup_id = ug.id " +
                        "JOIN curator c ON ug.curator_id = c.id " +
                        "JOIN university u ON ug.university_id = u.id " +
                        "GROUP BY uName, ugName, curName, stName ORDER BY ug.name")
                .getResultList();
        return resultList;
    }
}