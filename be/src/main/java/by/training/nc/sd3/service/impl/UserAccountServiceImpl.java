package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.repository.UserAccountRepository;
import by.training.nc.sd3.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public Optional<UserAccount> getUserAccount(String name, String password) {
        Iterable<UserAccount> allAccounts = this.userAccountRepository.findAll();
        AtomicReference<UserAccount> responseUserAccount = new AtomicReference<>();
        allAccounts.forEach(
                userAccount -> {
                    if(userAccount.getName().equals(name) && userAccount.getPassword().equals(password))
                        responseUserAccount.set(userAccount);

                }
        );
        return Optional.ofNullable(responseUserAccount.get());
    }

    public Optional<UserAccount> getUserAccountById(Long id) {
        return this.userAccountRepository.findById(id);
    }

}
