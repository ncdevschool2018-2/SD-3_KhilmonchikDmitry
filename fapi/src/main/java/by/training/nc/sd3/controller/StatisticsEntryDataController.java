package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.Categories;
import by.training.nc.sd3.models.StatisticsEntryViewModel;
import by.training.nc.sd3.service.StatisticsEntryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsEntryDataController {

    @Autowired
    private StatisticsEntryDataService statisticsEntryDataService;

    @RequestMapping(value = "/for-billing-account", method = RequestMethod.GET)
    public ResponseEntity<List<StatisticsEntryViewModel>> getStatisticsByBillingAccountId(@RequestParam("billingAccountId") Long id) {
        return ResponseEntity.ok(this.statisticsEntryDataService.getStatisticsForBillingAccount(id));
    }

    @RequestMapping(value = "/by-category", method = RequestMethod.GET)
    public ResponseEntity<List<StatisticsEntryViewModel>> getStatisticsByBillingAccountId(@RequestParam("category") int category) {
        return ResponseEntity.ok(this.statisticsEntryDataService.getStatisticsByCategory(Categories.values()[category]));
    }

}
