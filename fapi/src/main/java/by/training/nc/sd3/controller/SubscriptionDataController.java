package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.SubscriptionViewModel;
import by.training.nc.sd3.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subs")
public class SubscriptionDataController {

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<SubscriptionViewModel>> getSubscriptions() {
        return ResponseEntity.ok(subscriptionDataService.getAll());
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity<SubscriptionViewModel> getSubscriptionById(@RequestParam String id) {
        return ResponseEntity.ok(subscriptionDataService.getSubscriptionById(Long.valueOf(id)));
    }

    @RequestMapping(value = "/getbyname", method = RequestMethod.GET)
    public ResponseEntity<SubscriptionViewModel> getSubscriptionByName(@RequestParam String name) {
        return ResponseEntity.ok(subscriptionDataService.getSubscriptionByName(name));
    }

    @RequestMapping(value = "/getbycategory", method = RequestMethod.GET)
    public ResponseEntity<List<SubscriptionViewModel>> getSubscriptionByCategory(@RequestParam String category) {
        return ResponseEntity.ok(subscriptionDataService.getSubscriptionByCategory(category));
    }
}
