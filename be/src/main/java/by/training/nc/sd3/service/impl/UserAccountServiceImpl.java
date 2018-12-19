package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.repository.BillingAccountRepository;
import by.training.nc.sd3.repository.SubscriptionUnitRepository;
import by.training.nc.sd3.repository.UserAccountRepository;
import by.training.nc.sd3.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAccountServiceImpl implements UserAccountService {

    private UserAccountRepository userAccountRepository;
    private BillingAccountRepository billingAccountRepository;
    private SubscriptionUnitRepository subscriptionUnitRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository,
                                  BillingAccountRepository billingAccountRepository,
                                  SubscriptionUnitRepository subscriptionUnitRepository) {
        this.userAccountRepository = userAccountRepository;
        this.billingAccountRepository = billingAccountRepository;
        this.subscriptionUnitRepository = subscriptionUnitRepository;
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
        UserAccount ua = userAccountRepository.save(userAccount);
        Optional<BillingAccount> billingAccount = this.billingAccountRepository.findById(userAccount.getActiveBillingAccountId());
        if(billingAccount.isPresent()) {
            billingAccount.get().setOwnerId(ua.getId());
            this.billingAccountRepository.save(billingAccount.get());
        }
        return ua;
    }

    @Override
    public UserAccount ban(UserAccount userAccount) {
        userAccount.setIsBanned(true);
        return this.userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount unBan(UserAccount userAccount) {
        userAccount.setIsBanned(false);
        return this.userAccountRepository.save(userAccount);
    }

    @Override
    public Iterable<UserAccount> getAll() {
        return this.userAccountRepository.findAll();
    }

    @Override
    public UserAccount changeActiveBillingAccount(UserAccount userAccount, Long billingAccountId) {
        userAccount.setActiveBillingAccountId(billingAccountId);
        return this.userAccountRepository.save(userAccount);
    }

    @Override
    public Integer getSubscriptionsQuantity(Long id) {
        return this.subscriptionUnitRepository.countByUserId(id);
    }

}
