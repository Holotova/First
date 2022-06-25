package ua.holotova.thirdModule.service;

import ua.holotova.thirdModule.dao.StudyGroupDao;
import ua.holotova.thirdModule.model.StudyGroup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ua.holotova.thirdModule.service.UniversityManagementSystemService.UNIVERSITY;

public class StudyGroupService {
    private final static StudyGroupDao STUDY_GROUP_DAO = new StudyGroupDao();
    private final static Scanner SCANNER = new Scanner(System.in);

    public List<StudyGroup> createStudyGroup() {
        final StudyGroup studyGroup1 = new StudyGroup("ECON-IER-111", UNIVERSITY);
        final StudyGroup studyGroup2 = new StudyGroup("ECON-MAM-222", UNIVERSITY);
        final StudyGroup studyGroup3 = new StudyGroup("ECON-ACC-333", UNIVERSITY);
        return Arrays.asList(studyGroup1, studyGroup2, studyGroup3);
    }

    public void printGroupsByNamePart() {
        System.out.println("Please enter part of group name ");
        String namePart = SCANNER.nextLine();
        List<StudyGroup> groups = STUDY_GROUP_DAO.getGroupByNamePart(namePart);
        if(groups.size() == 0){
            System.out.println("Not found any group");
        }
        groups.forEach(System.out::println);
    }

    public void printQtyStudentsInGroups() {
        System.out.println("Number of students in each group:");
        List<Object[]> learnersInGroup = STUDY_GROUP_DAO.countStudentsInGroups();
        for (Object[] object : learnersInGroup) {
            String groupName = object[0].toString();
            Number learners = (Number) object[1];
            System.out.printf("Group: %s, number of students: %d. \n",
                    groupName, learners);
        }
    }

    public void printAverageMarksInGroups() {
        System.out.println("Average marks of each group:");
        List<Object[]> learnersInGroup = STUDY_GROUP_DAO.getAverageMarkInGroups();
        for (Object[] object : learnersInGroup) {
            System.out.printf("Group: %s, average mark in group: %.2f. \n",
                    object[0], object[1]);
        }
    }

}
