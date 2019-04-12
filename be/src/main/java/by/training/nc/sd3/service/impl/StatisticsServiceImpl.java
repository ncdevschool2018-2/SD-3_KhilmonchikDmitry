package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.Categories;
import by.training.nc.sd3.entity.StatisticsEntry;
import by.training.nc.sd3.repository.StatisticsEntryRepository;
import by.training.nc.sd3.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class StatisticsServiceImpl implements StatisticsService {

    private StatisticsEntryRepository statisticsEntryRepository;

    @Autowired
    public StatisticsServiceImpl(StatisticsEntryRepository statisticsEntryRepository) {
        this.statisticsEntryRepository = statisticsEntryRepository;
    }

    @Override
    public Iterable<StatisticsEntry> getStatisticsForBillingAccount(Long billingAccountId) {
        return this.statisticsEntryRepository
                .findByBillingAccountId(billingAccountId);
    }

//    @Override
//    public Iterable<StatisticsEntry> getStatisticsForCurrentMonth() {
//        LocalDateTime currentDate = LocalDateTime.now();
//        return this.statisticsEntryRepository.findByDateMonth(currentDate.getMonth());
//    }

    @Override
    public Iterable<StatisticsEntry> getStatisticsForCategory(int category) {
        return this.statisticsEntryRepository.findByServiceIdCategory(category);
    }
}
