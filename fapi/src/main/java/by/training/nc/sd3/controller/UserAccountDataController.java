package by.training.nc.sd3.controller;

import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ua")
public class UserAccountDataController {

    @Autowired
    private UserAccountDataService userAccountDataService;

    @RequestMapping
    public ResponseEntity<List<UserAccountViewModel>> getAllUserAccounts() {
        return ResponseEntity.ok(userAccountDataService.getAll());
    }

    @RequestMapping
    public ResponseEntity<UserAccountViewModel> getUserAccountById(int id) {
        return ResponseEntity.ok(userAccountDataService.getUserAccountById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> saveUserAccount(@RequestBody UserAccountViewModel userAccount) {
        if (userAccount != null)
            return ResponseEntity.ok(userAccountDataService.saveUserAccount(userAccount));
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable String id) {
        userAccountDataService.deleteUserAccountById(Integer.valueOf(id));
    }
}
