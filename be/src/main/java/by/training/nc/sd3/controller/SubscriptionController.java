package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.Subscription;
import by.training.nc.sd3.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/subscriptions")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @RequestMapping(value = "")
    public Iterable<Subscription> getAllSubscriptions() {
        return subscriptionService.getSubscriptions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Subscription> getSubscriptionById(@PathVariable(name = "id") Long id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @RequestMapping(value = "by-category", method = RequestMethod.GET)
    public Iterable<Subscription> getSubscriptionsByCategory(@RequestParam Long category) {
        return subscriptionService.getSubscriptionsByCategory(category);
    }

    @RequestMapping(value = "by-name", method = RequestMethod.GET)
    public Subscription getSubscriptionsByName(@RequestParam String name) {
        return subscriptionService.getSubscriptionsByName(name);
    }

    @PostMapping(value = "save")
    public Subscription save(@RequestBody Subscription subscription) {
        return subscriptionService.save(subscription);
    }

    @PostMapping(value = "ban")
    public Subscription ban(@RequestBody Long id) {
        return subscriptionService.ban(id);
    }

    @PostMapping(value = "unban")
    public Subscription unBan(@RequestBody Long id) {
        return subscriptionService.unBan(id);
    }
}
