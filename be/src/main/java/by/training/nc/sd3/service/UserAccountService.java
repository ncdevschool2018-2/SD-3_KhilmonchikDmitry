package by.training.nc.sd3.service;
import by.training.nc.sd3.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService {

    Optional<by.training.nc.sd3.entity.UserAccount> getUserAccount(String name, String password);
    Optional<by.training.nc.sd3.entity.UserAccount> getUserAccountById(Long id);
    UserAccount save(UserAccount userAccount);
    UserAccount ban(UserAccount userAccount);
    UserAccount unBan(UserAccount userAccount);
    Iterable<UserAccount> getAll();
    UserAccount changeActiveBillingAccount(UserAccount userAccount, Long billingAccountId);
    Integer getSubscriptionsQuantity(Long id);
}
