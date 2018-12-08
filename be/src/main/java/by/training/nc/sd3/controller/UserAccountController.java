package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/user-accounts")
public class UserAccountController {

    private UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Optional<UserAccount> getAllSubscriptions(String login, String password) {
        return userAccountService.getUserAccount(login, password);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<UserAccount> getUserAccountById(@PathVariable(name = "id") Long id) {
        return userAccountService.getUserAccountById(id);
    }

    @PostMapping(value = "/save")
    public UserAccount save(@RequestBody UserAccount userAccount, @RequestParam Long activeBillingAccountId) {
        userAccount.setActiveBillingAccountId(activeBillingAccountId);
        return userAccountService.save(userAccount);
    }

    @PostMapping(value = "ban")
    public UserAccount ban(@RequestBody UserAccount userAccount) {
        return this.userAccountService.ban(userAccount);
    }

    @PostMapping(value = "unBan")
    public UserAccount unBan(@RequestBody UserAccount userAccount) {
        return this.userAccountService.unBan(userAccount);
    }
}
