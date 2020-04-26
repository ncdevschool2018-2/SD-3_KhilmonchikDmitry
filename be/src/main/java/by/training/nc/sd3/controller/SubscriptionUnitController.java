package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.ProductInstance;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.ProductInstanceService;
import by.training.nc.sd3.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/subscription-units")
public class SubscriptionUnitController {

    private ProductInstanceService productInstanceService;
    private UserAccountService userAccountService;
    private BillingAccountService billingAccountService;

    public SubscriptionUnitController(ProductInstanceService productInstanceService,
                                      UserAccountService userAccountService,
                                      BillingAccountService billingAccountService) {
        this.productInstanceService = productInstanceService;
        this.userAccountService = userAccountService;
        this.billingAccountService = billingAccountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ProductInstance> getAll() {
        return productInstanceService.getSubscriptionUnits();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ProductInstance save(@RequestBody ProductInstance productInstance) {
        Optional<UserAccount> userAccountOpt = userAccountService.getUserAccountById(productInstance.getUserId());
        if (userAccountOpt.isPresent() && userAccountOpt.get().getActiveBillingAccountId() != null) {
            Optional<BillingAccount> billingAccountOpt = billingAccountService.getById(userAccountOpt.get().getActiveBillingAccountId());
            if (billingAccountOpt.isPresent()) {
                productInstance.setBillingAccount(billingAccountOpt.get());
            }
        }
        return productInstanceService.save(productInstance);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        productInstanceService.delete(id);
    }

    @RequestMapping(value = "/get-by-user-id", method = RequestMethod.GET)
    public Iterable<ProductInstance> getByUserAccountId(@RequestParam("userId") Long id) {
        return productInstanceService.getByUserId(id);
    }

    @PostMapping(value = "/change-status")
    public ProductInstance changeStatus(@RequestBody ProductInstance productInstance) {
        return productInstanceService.changeStatus(productInstance);
    }
}
