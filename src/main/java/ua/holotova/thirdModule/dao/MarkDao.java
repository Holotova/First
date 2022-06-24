package ua.holotova.thirdModule.dao;

import ua.holotova.thirdModule.model.Mark;

public class MarkDao extends AbstractDao<Mark> {
    @Override
    protected void init() {
        aClass = Mark.class;
    }
}
