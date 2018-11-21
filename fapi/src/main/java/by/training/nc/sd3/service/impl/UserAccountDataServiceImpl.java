package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.UserAccountViewModel;
import by.training.nc.sd3.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserAccountDataServiceImpl implements UserAccountDataService {

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    public UserAccountViewModel getUserAccountById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        UserAccountViewModel userAccount = restTemplate.getForObject(backendServerUrl + "/api/user-accounts/{id}?id={id}",
                UserAccountViewModel.class, id, id);
        return userAccount;
    }

    public UserAccountViewModel getUserAccountByData(String login, String password) {
        RestTemplate restTemplate = new RestTemplate();
        UserAccountViewModel userAccount = restTemplate.getForObject(backendServerUrl + "/api/user-accounts?login={login}&password={password}",
                UserAccountViewModel.class, login, password);
        return userAccount;
    }

    public UserAccountViewModel saveUserAccount(UserAccountViewModel account) {
        return null;
    }
}
