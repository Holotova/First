package ua.holotova.hw25.dao;

import ua.holotova.hw25.config.HibernateFactoryUtil;
import ua.holotova.hw25.model.Curator;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class CuratorDao extends AbstractDao<Curator> {
    @Override
    protected void init() {

        aClass = Curator.class;
    }

    public List<Curator> getCuratorByAgeExperience(LocalDate dateTo, Integer experience) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Curator> query = criteriaBuilder.createQuery(Curator.class);
        final Root<Curator> root = query.from(Curator.class);
        Predicate beforeDate = criteriaBuilder.lessThan(root.get("birthDate").as(LocalDate.class), dateTo);
        Predicate experienceMore = criteriaBuilder.gt(root.get("workExperience"), experience);
        query.select(root).where(criteriaBuilder.and(beforeDate, experienceMore));
        return entityManager.createQuery(query).getResultList();
    }
}
