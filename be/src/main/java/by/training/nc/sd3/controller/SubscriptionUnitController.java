package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.service.SubscriptionUnitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subscription-units")
public class SubscriptionUnitController {

    private SubscriptionUnitService subscriptionUnitService;

    public SubscriptionUnitController(SubscriptionUnitService subscriptionUnitService) {
        this.subscriptionUnitService = subscriptionUnitService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<SubscriptionUnit> getAll() {
        return subscriptionUnitService.getSubscriptionUnits();
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public SubscriptionUnit save(SubscriptionUnit subscriptionUnit) {
        return subscriptionUnitService.save(subscriptionUnit);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void delete(Long id) {
        subscriptionUnitService.delete(id);
    }
}
