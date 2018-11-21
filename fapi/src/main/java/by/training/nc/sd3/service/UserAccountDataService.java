package by.training.nc.sd3.service;

import by.training.nc.sd3.models.UserAccountViewModel;

import java.util.List;

public interface UserAccountDataService {
    UserAccountViewModel getUserAccountById(int id);
    UserAccountViewModel getUserAccountByData(String login, String password);
    UserAccountViewModel saveUserAccount(UserAccountViewModel account);
}
