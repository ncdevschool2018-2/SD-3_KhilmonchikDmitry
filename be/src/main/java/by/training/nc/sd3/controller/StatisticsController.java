package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.Categories;
import by.training.nc.sd3.entity.StatisticsEntry;
import by.training.nc.sd3.service.StatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/statistics")
public class StatisticsController {

    private StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value = "/for-billing-account", method = RequestMethod.GET)
    public Iterable<StatisticsEntry> getStatisticsForBillngAccount(Long billingAccountId) {
        return this.statisticsService.getStatisticsForBillingAccount(billingAccountId);
    }

    @RequestMapping(value = "/by-category", method = RequestMethod.GET)
    public Iterable<StatisticsEntry> getStatisticsByCategory(int category) {
        return this.statisticsService.getStatisticsForCategory(category);
    }

//    @RequestMapping(value = "/by-month", method = RequestMethod.GET)
//    public Iterable<StatisticsEntry> getStatisticsByMonth() {
//        return this.statisticsService.getStatisticsForCurrentMonth();
//    }
}