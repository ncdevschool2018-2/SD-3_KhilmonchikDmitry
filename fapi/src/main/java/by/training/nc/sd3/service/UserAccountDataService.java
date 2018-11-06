package by.training.nc.sd3.service;

import by.training.nc.sd3.models.UserAccountViewModel;

import java.util.List;

public interface UserAccountDataService {
    List<UserAccountViewModel> getAll();
    UserAccountViewModel getUserAccountById(int id);
    UserAccountViewModel saveUserAccount(UserAccountViewModel account);
    void deleteUserAccountById(int id);
}
