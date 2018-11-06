package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.models.SubscriptionViewModel;
import by.training.nc.sd3.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subs")
public class SubscriptionDataController {

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping
    public ResponseEntity<List<SubscriptionViewModel>> getSubscriptions(int id) {
        return ResponseEntity.ok(subscriptionDataService.getAll());
    }
}
