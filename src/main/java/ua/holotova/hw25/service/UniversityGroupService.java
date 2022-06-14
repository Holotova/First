package ua.holotova.hw25.service;

import ua.holotova.hw25.dao.UniversityGroupDao;
import ua.holotova.hw25.model.University;
import ua.holotova.hw25.model.UniversityGroup;

import java.util.List;

public class UniversityGroupService {
    private final static UniversityGroupDao universityGroupDao = new UniversityGroupDao();

    public UniversityGroup creatUniversityGroup(String name, University university) {
        return new UniversityGroup(name, university);
    }

    public void printQtyStudentsByGroup() {
        List<Object[]> stInGroup = universityGroupDao.countStudentsByGroup();
        for (Object[] objects : stInGroup) {
            String groupName = objects[0].toString();
            Number students = (Number) objects[1];
            System.out.printf("Group: %s, number of students: %d. \n",
                    groupName, students);
        }
    }


}
