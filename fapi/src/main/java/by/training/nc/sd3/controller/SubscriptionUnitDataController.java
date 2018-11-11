package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.SubscriptionUnitViewModel;
import by.training.nc.sd3.service.SubscriptionUnitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subsunits")
public class SubscriptionUnitDataController {

    @Autowired
    private SubscriptionUnitDataService subscriptionUnitDataService;

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity<List<SubscriptionUnitViewModel>> getSubscriptions(int id) {
        return ResponseEntity.ok(subscriptionUnitDataService.getSubscriptionUnitsById(id));
    }

}
