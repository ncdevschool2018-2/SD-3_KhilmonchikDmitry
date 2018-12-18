package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("/api/ua")
public class UserAccountDataController {

    @Autowired
    private UserAccountDataService userAccountDataService;

    @RequestMapping(value = "/get-by-id", method = RequestMethod.GET)
    public ResponseEntity<UserAccountViewModel> getUserAccountById(@RequestParam Long id) {
        return ResponseEntity.ok(userAccountDataService.getUserAccountById(id));
    }

    @PostMapping(value = "/get-all")
    public ResponseEntity<UserAccountViewModel[]> getAll() {
        return ResponseEntity.ok(userAccountDataService.getAll());
    }

    @RequestMapping(value = "/user")
    public UserAccountViewModel user(UserAccountViewModel userAccountViewModel) {
        return userAccountViewModel;
    }

    @RequestMapping(value = "/get-by-data", method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> getUserAccountByData(@RequestParam String login, @RequestBody String password) {
        return ResponseEntity.ok(userAccountDataService.getUserAccountByData(login, password));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> saveUserAccount(@RequestBody UserAccountViewModel userAccount, @RequestParam Long activeBillingAccountId) {
        if (userAccount != null) {
            System.out.println(userAccount);
            return ResponseEntity.ok(userAccountDataService.saveUserAccount(userAccount, activeBillingAccountId));
        }
        return null;
    }

    @PostMapping(value = "ban")
    public ResponseEntity<UserAccountViewModel> ban(@RequestBody UserAccountViewModel userAccountViewModel) {
        return ResponseEntity.ok(userAccountDataService.ban(userAccountViewModel));
    }

    @PostMapping(value = "unban")
    public ResponseEntity<UserAccountViewModel> unBan(@RequestBody UserAccountViewModel userAccountViewModel) {
        return ResponseEntity.ok(userAccountDataService.unBan(userAccountViewModel));
    }

    @PostMapping(value = "change-BillingAccount")
    public ResponseEntity<UserAccountViewModel> changeActiveBillingAccount(@RequestBody UserAccountViewModel userAccountViewModel,
                                                                           @RequestParam Long billingAccountId) {
        return ResponseEntity.ok(userAccountDataService.changeActiveBillingAccount(userAccountViewModel, billingAccountId));
    }
}
