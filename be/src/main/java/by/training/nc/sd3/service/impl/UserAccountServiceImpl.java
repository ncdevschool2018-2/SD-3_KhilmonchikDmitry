package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.repository.UserAccountRepository;
import by.training.nc.sd3.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public Optional<UserAccount> getUserAccount(String name, String password) {
        Optional<UserAccount> allAccounts = this.userAccountRepository.findByNameAndPassword(name, password);
        return allAccounts;
    }

    public Optional<UserAccount> getUserAccountById(Long id) {
        return this.userAccountRepository.findById(id);
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

}
