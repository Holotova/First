package ua.holotova.thirdModule.service;

import ua.holotova.thirdModule.dao.EconomicUniversityDao;
import ua.holotova.thirdModule.dao.LecturerDao;
import ua.holotova.thirdModule.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class UniversityManagementSystemService {
    private static final Random RANDOM = new Random();
    public static final EconomicUniversity UNIVERSITY = createUniversity();
    private final EconomicUniversityDao economicUniversityDao = new EconomicUniversityDao();
    private final LecturerDao lecturerDao = new LecturerDao();
    private final StudyGroupService studyGroupService = new StudyGroupService();
    private final LearnerService learnerService = new LearnerService();
    private final LecturerService lecturerService = new LecturerService();
    private final UniversitySubjectService subjectService = new UniversitySubjectService();
    private final MarkService markService = new MarkService();

    public static EconomicUniversity createUniversity(){
        return new EconomicUniversity("University of Economics");
    }

    public void createUniversitySystem() {
        addInfrastructure();
        economicUniversityDao.save(UNIVERSITY);
    }

    public void addInfrastructure() {
        List<StudyGroup> studyGroups = studyGroupService.createStudyGroup();
        List<Learner> learnersGroup1 = learnerService.createLearnerForGroup1();
        List<Learner> learnersGroup2 = learnerService.createLearnerForGroup2();
        List<Learner> learnersGroup3 = learnerService.createLearnerForGroup3();
        List<Lecturer> lecturers = lecturerService.createLecturers();
        List<UniversitySubject> subjects = subjectService.createUniversitySubject();
        Set<Mark> marks = markService.createMarks();

        UNIVERSITY.setStudyGroups(studyGroups);

        StudyGroup group1 = studyGroups.get(0);
        StudyGroup group2 = studyGroups.get(1);
        StudyGroup group3 = studyGroups.get(2);

        learnersGroup1.forEach(learner -> {learner.setStudyGroup(group1);});
        learnersGroup2.forEach(learner -> {learner.setStudyGroup(group2);});
        learnersGroup3.forEach(learner -> {learner.setStudyGroup(group3);});

        group1.setLearners(learnersGroup1);
        group2.setLearners(learnersGroup2);
        group3.setLearners(learnersGroup3);

        List<Learner> learners = new ArrayList<>();
        learners.addAll(learnersGroup1);
        learners.addAll(learnersGroup2);
        learners.addAll(learnersGroup3);

        for (int i = 0, j = 0; i < lecturers.size(); i++, j++) {
            lecturers.get(i).setUniversitySubject(subjects.get(j));
            subjects.get(j).setLecturer(lecturers.get(i));
            lecturerDao.save(lecturers.get(i));
        }

        subjects.forEach(subject -> { subject.setMark(marks);});

        marks.forEach(mark -> {
            mark.setLearner(learners.get(RANDOM.nextInt(0, learners.size() - 1)));
            mark.setSubject(subjects.get(RANDOM.nextInt(0, subjects.size() - 1)));
        });

        learners.forEach(learner -> {
            learner.setMarks(marks);
        });
    }
}

