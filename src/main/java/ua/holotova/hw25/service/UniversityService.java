package ua.holotova.hw25.service;

import ua.holotova.hw25.dao.UniversityDao;
import ua.holotova.hw25.model.University;
import ua.holotova.hw25.model.UniversityGroup;

import java.util.*;

public class UniversityService {
    private final UniversityGroupService universityGroupService = new UniversityGroupService();
    private final StudentService studentService = new StudentService();
    private final CuratorService curatorService = new CuratorService();
    private final UniversityDao universityDao = new UniversityDao();
    private final CourseService courseService = new CourseService();


    public void creatUniversityInfrastructure() {
        final List<University> universities = creatUniversity();

        final University university1 = universities.get(0);
        final UniversityGroup universityGroup1 =
                universityGroupService.creatUniversityGroup("universityGroup1", university1);
        final UniversityGroup universityGroup2 =
                universityGroupService.creatUniversityGroup("universityGroup2", university1);
        final UniversityGroup universityGroup3 =
                universityGroupService.creatUniversityGroup("universityGroup3", university1);

        final Set<UniversityGroup> universityGroups = new HashSet<>();
        universityGroups.add(universityGroup1);
        universityGroups.add(universityGroup2);
        universityGroups.add(universityGroup3);
        university1.setUniversityGroups(universityGroups);

        studentService.addStudents(universityGroup1, 2);
        studentService.addStudents(universityGroup2, 4);
        studentService.addStudents(universityGroup3, 6);

        curatorService.addCurator(universityGroup1);
        curatorService.addCurator(universityGroup2);
        curatorService.addCurator(universityGroup3);

        universityGroup1.getStudents().forEach(student -> courseService.setCourse(student, 3));

        for (University university : universities) {
            universityDao.save(university);
        }
    }

    private List<University> creatUniversity() {
        final University university1 = new University("university1");
        final University university2 = new University("university2");
        return Arrays.asList(university1, university2);
    }

    public void printInfrastructure() {
        universityDao.getAll().forEach(university -> {
            System.out.println(university.getName());
            Optional.ofNullable(university.getUniversityGroups())
                    .ifPresent(universityGroups -> universityGroups.forEach(universityGroup -> {
                        System.out.printf("Group: %s\n   Curator: %s\n         Students: %s\n",
                                universityGroup.getName(), universityGroup.getCurator().getName(),
                                universityGroup.getStudents().toString());
                    }));
        });
    }

}
