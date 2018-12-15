package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.repository.BillingAccountRepository;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.SubscriptionUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class BillingAccountServiceImpl implements BillingAccountService {

    private BillingAccountRepository repository;
    private SubscriptionUnitService subscriptionUnitService;

    @Autowired
    public BillingAccountServiceImpl(BillingAccountRepository repository, SubscriptionUnitService subscriptionUnitService) {
        this.repository = repository;
        this.subscriptionUnitService = subscriptionUnitService;
    }

    @Override
    public Iterable<BillingAccount> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Iterable<BillingAccount> getAllByOwnerId(Long ownerId) {
        return this.repository.findByOwnerId(ownerId);
    }

    @Override
    public Optional<BillingAccount> getById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public BillingAccount save(BillingAccount billingAccount) {
        return this.repository.save(billingAccount);
    }

    @Override
    public void delete(Long id, String password) {
        Optional<BillingAccount> billingAccountOptional = this.repository.findById(id);
        if(billingAccountOptional.isPresent()) {
            if(billingAccountOptional.get().getPassword().equals(password)) {
                this.repository.delete(billingAccountOptional.get());
                Iterable<SubscriptionUnit> subscriptionUnits = this.subscriptionUnitService.getByBillingAccountId(id);
                subscriptionUnits.forEach(
                        subscriptionUnit -> {
                            subscriptionUnit.setWillBeRenewed(false);
                            this.subscriptionUnitService.save(subscriptionUnit);
                        }
                );
            }
        }
    }

    @Override
    public BillingAccount addMoney(BillingAccount ba) {
        Optional<BillingAccount> billingAccountOptional = this.repository.findByNameAndPasswordAndCreditCardNumber(ba.getName(),
                ba.getPassword(), ba.getCreditCardNumber());
        if(billingAccountOptional.isPresent()) {
            BillingAccount billingAccount = billingAccountOptional.get();
            billingAccount.setMoney(billingAccount.getMoney() + ba.getMoney());
            this.repository.save(billingAccount);
            return billingAccount;
        }
        return null;
    }

    @Override
    public BillingAccount ban(BillingAccount billingAccount) {
        billingAccount.setBanned(true);
        return this.repository.save(billingAccount);
    }

    @Override
    public BillingAccount unBan(BillingAccount billingAccount) {
        billingAccount.setBanned(false);
        return this.repository.save(billingAccount);
    }


}
