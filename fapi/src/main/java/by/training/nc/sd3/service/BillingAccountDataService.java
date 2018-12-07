package by.training.nc.sd3.service;

import by.training.nc.sd3.models.BillingAccountViewModel;

import java.util.List;

public interface BillingAccountDataService {
    List<BillingAccountViewModel> getAll();
    List<BillingAccountViewModel> getBillingAccountsByOwnerId(Long ownerId);
    BillingAccountViewModel getBillingAccountById(Long id);
    boolean checkPasswordById(String password, Long id);
    BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account);
    void deleteBillingAccountById(Long id, String password);
    BillingAccountViewModel addMoney(BillingAccountViewModel billingAccountViewModel);
}
