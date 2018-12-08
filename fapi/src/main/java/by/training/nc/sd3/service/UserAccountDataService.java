package by.training.nc.sd3.service;

import by.training.nc.sd3.models.UserAccountViewModel;

import java.util.List;

public interface UserAccountDataService {
    UserAccountViewModel getUserAccountById(Long id);
    UserAccountViewModel getUserAccountByData(String login, String password);
    UserAccountViewModel saveUserAccount(UserAccountViewModel account, Long activeBillingAccountId);
    UserAccountViewModel ban(UserAccountViewModel userAccountViewModel);
    UserAccountViewModel unBan(UserAccountViewModel userAccountViewModel);
}
