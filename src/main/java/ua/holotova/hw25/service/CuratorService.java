package ua.holotova.hw25.service;

import ua.holotova.hw25.dao.CuratorDao;
import ua.holotova.hw25.model.Curator;
import ua.holotova.hw25.model.UniversityGroup;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class CuratorService {
    private final static Random RANDOM = new Random();
    private final static CuratorDao curatorDao = new CuratorDao();

    public void addCurator(UniversityGroup universityGroup) {
        final Curator curator = new Curator("Curator-" + RANDOM.nextInt(10, 1000),
                LocalDate.of(RANDOM.nextInt(1960, 1990),
                        RANDOM.nextInt(1, 12),
                        RANDOM.nextInt(1, 28)), RANDOM.nextInt(1, 10));
        universityGroup.setCurator(curator);
        curator.setUniversityGroup(universityGroup);
    }

    public void printCuratorByAgeExperience(LocalDate dateTo, Integer minExperience) {
        List<Curator> curators;
        curators = curatorDao.getCuratorByAgeExperience(dateTo, minExperience);
        for (Curator curator : curators) {
            System.out.printf("Curators born before %s and with experience more than %d:\n%s\n",
                    dateTo.toString(), minExperience, curator);
        }
    }


}
