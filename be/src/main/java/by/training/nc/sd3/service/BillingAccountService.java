package by.training.nc.sd3.service;

import by.training.nc.sd3.entity.BillingAccount;

import java.util.Optional;

public interface BillingAccountService {

    Iterable<BillingAccount> getAll();
    Iterable<BillingAccount> getAllByOwnerId(Long ownerId);
    Optional<BillingAccount> getById(Long id);
    BillingAccount save(BillingAccount billingAccount);
    void delete(Long id, String password);
    BillingAccount addMoney(BillingAccount billingAccount);
}
