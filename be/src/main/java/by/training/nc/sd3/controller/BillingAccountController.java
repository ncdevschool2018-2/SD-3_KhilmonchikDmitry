package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.service.BillingAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/billing-accounts")
public class BillingAccountController {

    private BillingAccountService billingAccountService;

    public BillingAccountController(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<BillingAccount> getAll() {
        return this.billingAccountService.getAll();
    }

    @RequestMapping(value = "/by-owner-id", method = RequestMethod.GET)
    public Iterable<BillingAccount> getAllByOwnerId(@RequestParam Long ownerId) {
        return this.billingAccountService.getAllByOwnerId(ownerId);
    }

    @RequestMapping(value = "/by-id", method = RequestMethod.GET)
    public Optional<BillingAccount> getById(@RequestParam Long id) {
        return this.billingAccountService.getById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id, @RequestParam String password) {
        this.billingAccountService.delete(id, password);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public BillingAccount save(@RequestBody BillingAccount billingAccount) {
        return this.billingAccountService.save(billingAccount);
    }

    @RequestMapping(value = "/add-money", method = RequestMethod.POST)
    public BillingAccount addMoney(@RequestBody BillingAccount billingAccount) {
        return this.billingAccountService.addMoney(billingAccount);
    }

    @PostMapping(value = "/ban")
    public BillingAccount ban(@RequestBody BillingAccount billingAccount) {
        return this.billingAccountService.ban(billingAccount);
    }

    @PostMapping(value = "/unban")
    public BillingAccount unBan(@RequestBody BillingAccount billingAccount) {
        return this.billingAccountService.unBan(billingAccount);
    }

}
