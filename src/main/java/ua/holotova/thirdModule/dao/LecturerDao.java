package ua.holotova.thirdModule.dao;

import ua.holotova.thirdModule.model.Lecturer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LecturerDao extends AbstractDao<Lecturer> {
    @Override
    protected void init() {

        aClass = Lecturer.class;
    }

    public Lecturer getLecturerByFirstOrLastName(String name) {
        final CriteriaBuilder cb = ENTITY_MANAGER.getCriteriaBuilder();
        final CriteriaQuery<Lecturer> query = cb.createQuery(Lecturer.class);
        final Root<Lecturer> from = query.from(Lecturer.class);
        Predicate firstName = cb.equal(from.get("firstName"), name);
        Predicate lastName = cb.equal(from.get("lastName"), name);
        query.select(from).where(cb.or(firstName, lastName));
        return ENTITY_MANAGER.createQuery(query).getSingleResult();
    }
}
