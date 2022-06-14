package ua.holotova.hw25.dao;

import ua.holotova.hw25.config.HibernateFactoryUtil;
import ua.holotova.hw25.model.UniversityGroup;

import javax.persistence.EntityManager;
import java.util.List;

public class UniversityGroupDao extends AbstractDao<UniversityGroup> {
    @Override
    protected void init() {

    }

    public List<Object[]> countStudentsByGroup() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT ug.name, COUNT(ugs.student_id) " +
                        "FROM universitygroup_student ugs JOIN universitygroup ug ON ugs.universitygroup_id = ug.id " +
                        "GROUP BY ug.name")
                .getResultList();
        return resultList;
    }
}
