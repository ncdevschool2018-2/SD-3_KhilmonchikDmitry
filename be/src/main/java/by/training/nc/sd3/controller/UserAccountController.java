package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.service.impl.UserAccountServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/user-accounts")
public class UserAccountController {

    private UserAccountServiceImpl userAccountService;

    public UserAccountController(UserAccountServiceImpl userAccountService) {
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

}
