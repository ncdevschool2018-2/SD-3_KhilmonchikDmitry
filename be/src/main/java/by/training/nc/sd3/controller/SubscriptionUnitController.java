package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.SubscriptionUnitService;
import by.training.nc.sd3.service.UserAccountService;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/subscription-units")
public class SubscriptionUnitController {

    private SubscriptionUnitService subscriptionUnitService;
    private UserAccountService userAccountService;
    private BillingAccountService billingAccountService;

    public SubscriptionUnitController(SubscriptionUnitService subscriptionUnitService,
                                      UserAccountService userAccountService,
                                      BillingAccountService billingAccountService) {
        this.subscriptionUnitService = subscriptionUnitService;
        this.userAccountService = userAccountService;
        this.billingAccountService = billingAccountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<SubscriptionUnit> getAll() {
        return subscriptionUnitService.getSubscriptionUnits();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public SubscriptionUnit save(@RequestBody SubscriptionUnit subscriptionUnit) {
        Optional<UserAccount> userAccountOpt = userAccountService.getUserAccountById(subscriptionUnit.getUserId());
        if (userAccountOpt.isPresent() && userAccountOpt.get().getActiveBillingAccountId() != null) {
            Optional<BillingAccount> billingAccountOpt = billingAccountService.getById(userAccountOpt.get().getActiveBillingAccountId());
            if (billingAccountOpt.isPresent()) {
                subscriptionUnit.setBillingAccount(billingAccountOpt.get());
            }
        }
        return subscriptionUnitService.save(subscriptionUnit);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        subscriptionUnitService.delete(id);
    }

    @RequestMapping(value = "/get-by-user-id", method = RequestMethod.GET)
    public Iterable<SubscriptionUnit> getByUserAccountId(@RequestParam("userId") Long id) {
        return subscriptionUnitService.getByUserId(id);
    }

    @PostMapping(value = "/change-status")
    public SubscriptionUnit changeStatus(@RequestBody SubscriptionUnit subscriptionUnit) {
        return subscriptionUnitService.changeStatus(subscriptionUnit);
    }
}
