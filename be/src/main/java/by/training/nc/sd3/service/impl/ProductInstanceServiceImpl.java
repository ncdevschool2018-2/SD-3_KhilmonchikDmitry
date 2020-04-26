package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.ProductInstance;
import by.training.nc.sd3.entity.UserAccount;
import by.training.nc.sd3.repository.BillingAccountRepository;
import by.training.nc.sd3.repository.ProductInstanceRepository;
import by.training.nc.sd3.repository.UserAccountRepository;
import by.training.nc.sd3.service.ProductInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class ProductInstanceServiceImpl implements ProductInstanceService {

    private ProductInstanceRepository productInstanceRepository;
    private UserAccountRepository userAccountRepository;
    private BillingAccountRepository billingAccountRepository;

    @Autowired
    public ProductInstanceServiceImpl(ProductInstanceRepository productInstanceRepository,
                                      UserAccountRepository userAccountRepository,
                                      BillingAccountRepository billingAccountRepository) {
        this.productInstanceRepository = productInstanceRepository;
        this.userAccountRepository = userAccountRepository;
        this.billingAccountRepository = billingAccountRepository;
    }

    public Iterable<ProductInstance> getSubscriptionUnits() {
        return this.productInstanceRepository.findAll();
    }

    public ProductInstance save(ProductInstance productInstance) {
        Optional<UserAccount> userAccountOptional = this.userAccountRepository.findById(productInstance.getUserId());
        productInstance.setCreationDate(new Date());
        if (userAccountOptional.isPresent()) {
            UserAccount user = userAccountOptional.get();
            if (user.getActiveBillingAccountId() != null) {
                Optional<BillingAccount> billingAccountOptional =
                        this.billingAccountRepository.findById(user.getActiveBillingAccountId());
                if (billingAccountOptional.isPresent()) {
                    BillingAccount billingAccount = billingAccountOptional.get();
                    billingAccount.setMoney(billingAccount.getMoney() - productInstance.getProductOffering().getCost());
                    this.billingAccountRepository.save(billingAccount);
                    return this.productInstanceRepository.save(productInstance);
                }
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Iterable<ProductInstance> subscriptionUnitOptional = this.productInstanceRepository.findAll();
        subscriptionUnitOptional.forEach(
                subscriptionUnit -> {
                    if (subscriptionUnit.getId().equals(id))
                        this.productInstanceRepository.delete(subscriptionUnit);
                }
        );
    }

    @Override
    public Iterable<ProductInstance> getByBillingAccountId(Long ownerId) {
        return this.productInstanceRepository.getSubscriptionUnitsByBillingAccountId(ownerId);
    }

    @Override
    public Iterable<ProductInstance> getByUserId(Long userAccountId) {
        return this.productInstanceRepository.getSubscriptionUnitsByUserId(userAccountId);
    }

    @Override
    public Optional<ProductInstance> getById(Long id) {
        return this.productInstanceRepository.findById(id);
    }

    @Override
    public ProductInstance changeStatus(ProductInstance productInstance) {
        Optional<ProductInstance> subscriptionUnitOptional = this.productInstanceRepository.findById(productInstance.getId());
        if (subscriptionUnitOptional.isPresent()) {
            ProductInstance productInstanceDB = subscriptionUnitOptional.get();
            productInstanceDB.setStatus(!productInstanceDB.isStatus());
            return this.productInstanceRepository.save(productInstanceDB);
        }
        return null;
    }

    @Override
    public ProductInstance update(ProductInstance productInstance) {
        return this.productInstanceRepository.save(productInstance);
    }
}
