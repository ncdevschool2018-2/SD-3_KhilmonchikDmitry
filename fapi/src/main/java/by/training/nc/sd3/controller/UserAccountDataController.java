package by.training.nc.sd3.controller;

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

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity<UserAccountViewModel> getUserAccountById(@RequestParam int id) {
        return ResponseEntity.ok(userAccountDataService.getUserAccountById(id));
    }

    @RequestMapping(value = "/getbydata", method = RequestMethod.GET)
    public ResponseEntity<UserAccountViewModel> getUserAccountByData(@RequestParam String login, @RequestParam String password) {
        return ResponseEntity.ok(userAccountDataService.getUserAccountByData(login, password));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> saveUserAccount(@RequestBody UserAccountViewModel userAccount) {
        if (userAccount != null) {
            System.out.println(userAccount);
            return ResponseEntity.ok(userAccountDataService.saveUserAccount(userAccount));
        }
        return null;
    }
}
