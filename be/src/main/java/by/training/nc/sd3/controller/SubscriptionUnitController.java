package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.service.SubscriptionUnitService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "delete/{id}")
    @Transactional
    public void delete(@PathVariable("id") Long id) {
        subscriptionUnitService.delete(id);
    }

    @RequestMapping(value = "get-by-user-id", method = RequestMethod.GET)
    public Iterable<SubscriptionUnit> getByUserAccountId(@RequestParam("userId") Long id) {
        System.out.println(id);
        return subscriptionUnitService.getByUserId(id);
    }
}
