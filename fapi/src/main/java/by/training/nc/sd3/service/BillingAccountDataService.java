package by.training.nc.sd3.service;

import by.training.nc.sd3.models.BillingAccountViewModel;

import java.util.List;

public interface BillingAccountDataService {
    List<BillingAccountViewModel> getAll();
    BillingAccountViewModel getBillingAccountByOwnerId(int ownerId);
    BillingAccountViewModel getBillingAccountById(int id);
    BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account);
    void deleteBillingAccountById(int id);
}
