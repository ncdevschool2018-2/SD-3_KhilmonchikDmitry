package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.Categories;
import by.training.nc.sd3.models.StatisticsEntryViewModel;
import by.training.nc.sd3.service.StatisticsEntryDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StatisticsEntryDataServiceImpl implements StatisticsEntryDataService {

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    @Override
    public List<StatisticsEntryViewModel> getStatisticsForBillingAccount(Long billingAccountId) {
        RestTemplate restTemplate = new RestTemplate();
        StatisticsEntryViewModel[] statisticsEntryViewModels = restTemplate.getForObject(backendServerUrl + "/api/statistics/for-billing-account?billingAccountId={id}",
                StatisticsEntryViewModel[].class, billingAccountId);
        return statisticsEntryViewModels == null ? Collections.emptyList() : Arrays.asList(statisticsEntryViewModels);
    }

    @Override
    public List<StatisticsEntryViewModel> getStatisticsByCategory(Categories category) {
        RestTemplate restTemplate = new RestTemplate();
        StatisticsEntryViewModel[] statisticsEntryViewModels = restTemplate.getForObject(backendServerUrl + "/api/statistics/by-category?category={id}",
                StatisticsEntryViewModel[].class, category.ordinal());
        return statisticsEntryViewModels == null ? Collections.emptyList() : Arrays.asList(statisticsEntryViewModels);
    }
}
