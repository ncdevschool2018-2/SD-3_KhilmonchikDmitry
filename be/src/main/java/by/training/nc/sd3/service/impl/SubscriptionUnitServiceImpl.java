package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.repository.BillingAccountRepository;
import by.training.nc.sd3.repository.SubscriptionUnitRepository;
import by.training.nc.sd3.repository.UserAccountRepository;
import by.training.nc.sd3.service.SubscriptionUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class SubscriptionUnitServiceImpl implements SubscriptionUnitService {

    private SubscriptionUnitRepository subscriptionUnitRepository;
    private UserAccountRepository userAccountRepository;
    private BillingAccountRepository billingAccountRepository;

    @Autowired
    public SubscriptionUnitServiceImpl(SubscriptionUnitRepository subscriptionUnitRepository,
                                       UserAccountRepository userAccountRepository,
                                       BillingAccountRepository billingAccountRepository) {
        this.subscriptionUnitRepository = subscriptionUnitRepository;
        this.userAccountRepository = userAccountRepository;
        this.billingAccountRepository = billingAccountRepository;
    }

    public Iterable<SubscriptionUnit> getSubscriptionUnits() {
        return this.subscriptionUnitRepository.findAll();
    }

    public SubscriptionUnit save(SubscriptionUnit subscriptionUnit) {
        Optional<UserAccount> userAccountOptional = this.userAccountRepository.findById(subscriptionUnit.getUserId());
        subscriptionUnit.setCreationDate(new Date());
        subscriptionUnit.setWriteOffDate(new Date());
        if (userAccountOptional.isPresent()) {
            UserAccount user = userAccountOptional.get();
            if (user.getActiveBillingAccountId() != null) {
                Optional<BillingAccount> billingAccountOptional =
                        this.billingAccountRepository.findById(user.getActiveBillingAccountId());
                if (billingAccountOptional.isPresent()) {
                    BillingAccount billingAccount = billingAccountOptional.get();
                    if (!billingAccount.getIsBanned()) {
                        if (subscriptionUnit.getDaysLeft() == 30) {
                            if (billingAccount.getMoney() >= subscriptionUnit.getSubscription().getPerMonth()) {
                                billingAccount.setMoney(billingAccount.getMoney() - subscriptionUnit.getSubscription().getPerMonth());
                                this.billingAccountRepository.save(billingAccount);
                                return this.subscriptionUnitRepository.save(subscriptionUnit);
                            }
                        } else if (subscriptionUnit.getDaysLeft() == 90) {
                            if (billingAccount.getMoney() >= subscriptionUnit.getSubscription().getPerThreeMonths()) {
                                billingAccount.setMoney(billingAccount.getMoney() - subscriptionUnit.getSubscription().getPerThreeMonths());
                                this.billingAccountRepository.save(billingAccount);
                                return this.subscriptionUnitRepository.save(subscriptionUnit);
                            }
                        } else if (subscriptionUnit.getDaysLeft() == 365) {
                            if (billingAccount.getMoney() >= subscriptionUnit.getSubscription().getPerYear()) {
                                billingAccount.setMoney(billingAccount.getMoney() - subscriptionUnit.getSubscription().getPerYear());
                                this.billingAccountRepository.save(billingAccount);
                                return this.subscriptionUnitRepository.save(subscriptionUnit);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Iterable<SubscriptionUnit> subscriptionUnitOptional = this.subscriptionUnitRepository.findAll();
        subscriptionUnitOptional.forEach(
                subscriptionUnit -> {
                    if (subscriptionUnit.getId().equals(id))
                        this.subscriptionUnitRepository.delete(subscriptionUnit);
                }
        );
    }

    @Override
    public Iterable<SubscriptionUnit> getByBillingAccountId(Long ownerId) {
        return this.subscriptionUnitRepository.getSubscriptionUnitsByBillingAccountId(ownerId);
    }

    @Override
    public Iterable<SubscriptionUnit> getByUserId(Long userAccountId) {
        return this.subscriptionUnitRepository.getSubscriptionUnitsByUserId(userAccountId);
    }

    @Override
    public Optional<SubscriptionUnit> getById(Long id) {
        return this.subscriptionUnitRepository.findById(id);
    }

    @Override
    public SubscriptionUnit changeStatus(SubscriptionUnit subscriptionUnit) {
        Optional<SubscriptionUnit> subscriptionUnitOptional = this.subscriptionUnitRepository.findById(subscriptionUnit.getId());
        if(subscriptionUnitOptional.isPresent()) {
            SubscriptionUnit subscriptionUnitDB = subscriptionUnitOptional.get();
            subscriptionUnitDB.setStatus(!subscriptionUnitDB.isStatus());
            return this.subscriptionUnitRepository.save(subscriptionUnitDB);
        }
        return null;
    }

    @Override
    public SubscriptionUnit update(SubscriptionUnit subscriptionUnit) {
        return this.subscriptionUnitRepository.save(subscriptionUnit);
    }
}
