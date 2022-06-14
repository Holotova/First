package ua.holotova.hw25.dao;

import ua.holotova.hw25.config.HibernateFactoryUtil;
import ua.holotova.hw25.model.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentDao extends AbstractDao<Student> {
    @Override
    protected void init() {

        aClass = Student.class;
    }

    public List<Object[]> getStudentInfoById(Integer id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        List<Object[]> resultList = entityManager.createNativeQuery("SELECT s.name as sName, ug.name as ugName, " +
                        "c.name ascName, u.name asuName " +
                        "FROM student s JOIN universitygroup_student ugs ON s.id = ugs.student_id " +
                        "JOIN universitygroup ug ON ugs.universitygroup_id = ug.id " +
                        "JOIN curator c ON ug.curator_id = c.id " +
                        "JOIN university u ON ug.university_id = u.id " +
                        "where s.id = ?")
                .setParameter(1, id)
                .getResultList();
        return resultList;
    }
}