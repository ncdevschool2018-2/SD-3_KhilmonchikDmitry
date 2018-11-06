package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class BillingAccountDataController {

    @Autowired
    private BillingAccountDataService billingAccountDataService;

    @RequestMapping
    public ResponseEntity<List<BillingAccountViewModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(billingAccountDataService.getAll());
    }

    @RequestMapping
    public ResponseEntity<BillingAccountViewModel> getBillingAccountById(int id) {
        return ResponseEntity.ok(billingAccountDataService.getBillingAccountById(id));
    }

    @RequestMapping
    public ResponseEntity<BillingAccountViewModel> getBillingAccountByOwnerId(int id) {
        return ResponseEntity.ok(billingAccountDataService.getBillingAccountByOwnerId(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BillingAccountViewModel> saveBillingAccount(@RequestBody BillingAccountViewModel billingAccount) {
        if (billingAccount != null)
            return ResponseEntity.ok(billingAccountDataService.saveBillingAccount(billingAccount));
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable String id) {
        billingAccountDataService.deleteBillingAccountById(Integer.valueOf(id));
    }
}
