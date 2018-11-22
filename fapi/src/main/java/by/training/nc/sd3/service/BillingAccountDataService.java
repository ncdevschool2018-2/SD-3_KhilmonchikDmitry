package by.training.nc.sd3.service;

import by.training.nc.sd3.models.BillingAccountViewModel;

import java.util.List;

public interface BillingAccountDataService {
    List<BillingAccountViewModel> getAll();
    List<BillingAccountViewModel> getBillingAccountsByOwnerId(int ownerId);
    BillingAccountViewModel getBillingAccountById(int id);
    boolean checkPasswordById(String password, int id);
    BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account);
    void deleteBillingAccountById(int id);
}
