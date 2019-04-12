package by.training.nc.sd3.service;

import by.training.nc.sd3.entity.Categories;
import by.training.nc.sd3.entity.StatisticsEntry;

public interface StatisticsService {
    Iterable<StatisticsEntry> getStatisticsForBillingAccount(Long billingAccountId);
//    Iterable<StatisticsEntry> getStatisticsForCurrentMonth();
    Iterable<StatisticsEntry> getStatisticsForCategory(int category);
}
