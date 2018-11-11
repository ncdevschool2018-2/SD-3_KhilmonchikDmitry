package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserAccountDataServiceImpl implements UserAccountDataService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    public List<UserAccountViewModel> getAll() {
        List<UserAccountViewModel> allUsers = new LinkedList<UserAccountViewModel>();
        UserAccountViewModel user1 = new UserAccountViewModel(1, "Evstrat", "Petuh", "EvstratPetuh@mail.ru",false);
        UserAccountViewModel user2 = new UserAccountViewModel(2, "2", "2", "2@mail.ru", true);
        UserAccountViewModel user3 = new UserAccountViewModel(3, "3", "3", "3@mail.ru", false);

        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);

        return allUsers;
    }

    public UserAccountViewModel getUserAccountById(int id) {
        List<UserAccountViewModel> allUsers = new LinkedList<UserAccountViewModel>();
        UserAccountViewModel user1 = new UserAccountViewModel(1, "Evstrat", "Petuh", "EvstratPetuh@mail.ru", false);
        UserAccountViewModel user2 = new UserAccountViewModel(2, "2", "2", "2@mail.ru", true);
        UserAccountViewModel user3 = new UserAccountViewModel(3, "3", "3", "3@mail.ru", false);

        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getId() == id)
                return allUsers.get(i);
        }
        return null;
    }

    public UserAccountViewModel getUserAccountByData(String login, String password) {
        List<UserAccountViewModel> allUsers = new LinkedList<UserAccountViewModel>();
        UserAccountViewModel user1 = new UserAccountViewModel(1, "Evstrat", "Petuh", "EvstratPetuh@mail.ru", false);
        UserAccountViewModel user2 = new UserAccountViewModel(2, "2", "2", "2@mail.ru", true);
        UserAccountViewModel user3 = new UserAccountViewModel(3, "3", "3", "3@mail.ru", false);

        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getName().equals(login) && allUsers.get(i).getName().equals(password))
                return allUsers.get(i);
        }
        return null;
    }

    public UserAccountViewModel saveUserAccount(UserAccountViewModel account) {
        return null;
    }

    public void deleteUserAccountById(int id) {
        return;
    }
}
