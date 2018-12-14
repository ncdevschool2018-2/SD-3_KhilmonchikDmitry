package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class BillingAccountDataController {

    @Autowired
    private BillingAccountDataService billingAccountDataService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<BillingAccountViewModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(billingAccountDataService.getAll());
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity<BillingAccountViewModel> getBillingAccountById(@RequestParam Long id) {
        return ResponseEntity.ok(billingAccountDataService.getBillingAccountById(id));
    }

    @RequestMapping(value = "/getbyownerid", method = RequestMethod.GET)
    public ResponseEntity<List<BillingAccountViewModel>> getBillingAccountByOwnerId(@RequestParam Long id) {
        return ResponseEntity.ok(billingAccountDataService.getBillingAccountsByOwnerId(id));
    }

    @RequestMapping(value = "/checkpasswordbyid", method = RequestMethod.POST)
    public ResponseEntity<Boolean> checkPasswordById(@RequestBody BillingAccountViewModel ba) {
        return ResponseEntity.ok(billingAccountDataService.checkPasswordById(ba.getPassword(), ba.getId()));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<BillingAccountViewModel> saveBillingAccount(@RequestBody BillingAccountViewModel billingAccount) {
        if (billingAccount != null) {
            System.out.println(billingAccount);
            return ResponseEntity.ok(billingAccountDataService.saveBillingAccount(billingAccount));
        }
        return null;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable Long id, @RequestParam String password) {
        billingAccountDataService.deleteBillingAccountById(id, password);
    }

    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public ResponseEntity<BillingAccountViewModel> addMoney(@RequestBody BillingAccountViewModel billingAccount) {
        if (billingAccount != null) {
            return ResponseEntity.ok(billingAccountDataService.addMoney(billingAccount));
        }
        return null;
    }

    @PostMapping(value = "ban")
    public ResponseEntity<BillingAccountViewModel> ban(@RequestBody BillingAccountViewModel billingAccount) {
        return ResponseEntity.ok(billingAccountDataService.ban(billingAccount));
    }

    @PostMapping(value = "unban")
    public ResponseEntity<BillingAccountViewModel> unBan(@RequestBody BillingAccountViewModel billingAccount) {
        return ResponseEntity.ok(billingAccountDataService.unBan(billingAccount));
    }
}
