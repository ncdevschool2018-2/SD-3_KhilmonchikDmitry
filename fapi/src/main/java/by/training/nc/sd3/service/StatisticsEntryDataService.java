package by.training.nc.sd3.service;

import by.training.nc.sd3.models.Categories;
import by.training.nc.sd3.models.StatisticsEntryViewModel;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface StatisticsEntryDataService {

    List<StatisticsEntryViewModel> getStatisticsForBillingAccount(Long billingAccountId);

    List<StatisticsEntryViewModel> getStatisticsByCategory(Categories category);
}
