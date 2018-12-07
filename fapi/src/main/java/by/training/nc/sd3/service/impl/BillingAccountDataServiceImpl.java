package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class BillingAccountDataServiceImpl implements BillingAccountDataService {

    @Value("http://localhost:8081/")
    private String backendServerUrl;

    public List<BillingAccountViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccountViewModel[] billingAccounts = restTemplate.getForObject(backendServerUrl + "/api/billing-accounts",
                BillingAccountViewModel[].class);
        return billingAccounts == null ? Collections.emptyList() : Arrays.asList(billingAccounts);
    }

    public BillingAccountViewModel getBillingAccountById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccountViewModel billingAccount = restTemplate.getForObject(backendServerUrl + "/api/billing-accounts/by-id?id={id}",
                BillingAccountViewModel.class, id);
        return billingAccount;
    }

    public List<BillingAccountViewModel> getBillingAccountsByOwnerId(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccountViewModel[] billingAccounts = restTemplate.getForObject(backendServerUrl + "/api/billing-accounts/by-owner-id?ownerId={id}",
                BillingAccountViewModel[].class, id);
        return billingAccounts == null ? Collections.emptyList() : Arrays.asList(billingAccounts);
    }

    public boolean checkPasswordById(String password, Long id) {
        return false;
    }

    public BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccountViewModel billingAccount = restTemplate.postForObject(backendServerUrl + "/api/billing-accounts/save",
                account, BillingAccountViewModel.class);
        return billingAccount;
    }

    public void deleteBillingAccountById(Long id, String password) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl +
                        "/api/billing-accounts/delete/" + id + "?id=" + id + "&password=" + password);
    }

    @Override
    public BillingAccountViewModel addMoney(BillingAccountViewModel billingAccountViewModel) {
        System.out.println(billingAccountViewModel);
        RestTemplate restTemplate = new RestTemplate();
        BillingAccountViewModel billingAccount = restTemplate.postForObject(backendServerUrl + "/api/billing-accounts/add-money",
                billingAccountViewModel, BillingAccountViewModel.class);
        return  billingAccount;
    }
}
