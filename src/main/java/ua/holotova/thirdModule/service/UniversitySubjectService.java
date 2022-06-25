package ua.holotova.thirdModule.service;

import ua.holotova.thirdModule.dao.UniversitySubjectDao;
import ua.holotova.thirdModule.model.UniversitySubject;

import java.util.Arrays;
import java.util.List;

public class UniversitySubjectService {
    private final static UniversitySubjectDao UNIVERSITY_SUBJECT_DAO = new UniversitySubjectDao();

    public List<UniversitySubject> createUniversitySubject() {
        final UniversitySubject subject1 = new UniversitySubject("FIN-1", "International finance");
        final UniversitySubject subject2 = new UniversitySubject("FIN-2", "Enterprise finance");
        final UniversitySubject subject3 = new UniversitySubject("FIN-3", "Accounting");
        return Arrays.asList(subject1, subject2, subject3);
    }

    public void printBestWorstPercentageSubject() {
        List<Object[]> worstPercentageSubject = UNIVERSITY_SUBJECT_DAO.getWorstPercentageSubject();
        List<Object[]> bestPercentageSubject = UNIVERSITY_SUBJECT_DAO.getBestPercentageSubject();
        for (Object[] object : worstPercentageSubject) {
            System.out.printf("Subject with the worst percentage: %s, rate of advancement: %.2f. \n",
                    object[0], object[1]);
        }
        for (Object[] object : bestPercentageSubject) {
            System.out.printf("Subject with the best percentage: %s, rate of advancement: %.2f. \n",
                    object[0], object[1]);
        }
    }
}
