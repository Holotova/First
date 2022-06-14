package ua.holotova.hw25.dao;

import ua.holotova.hw25.config.HibernateFactoryUtil;
import ua.holotova.hw25.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CourseDao extends AbstractDao<Course> {
    @Override
    protected void init() {

        aClass = Course.class;
    }

    public List<Course> getCoursesByDifficulty(Integer diffFrom, Integer diffTo) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);
        final Root<Course> root = query.from(Course.class);
        query.select(root).where(criteriaBuilder.between(root.get("difficulty"), diffFrom, diffTo));
        return entityManager.createQuery(query).getResultList();
    }
}
