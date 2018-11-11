package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.models.BillingAccountViewModel;
import by.training.nc.sd3.service.BillingAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class BillingAccountDataServiceImpl implements BillingAccountDataService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    public List<BillingAccountViewModel> getAll() {
        List<BillingAccountViewModel> allBillingAccounts = new LinkedList<BillingAccountViewModel>();
        BillingAccountViewModel billing1 = new BillingAccountViewModel(1, 1, "1", "1", "1", 0);
        BillingAccountViewModel billing2 = new BillingAccountViewModel(2, 2, "2", "2", "2", 0);
        BillingAccountViewModel billing3 = new BillingAccountViewModel(3, 3, "3", "3", "3", 0);
        BillingAccountViewModel billing4 = new BillingAccountViewModel(4, 1, "4", "4", "4", 0);

        allBillingAccounts.add(billing1);
        allBillingAccounts.add(billing2);
        allBillingAccounts.add(billing3);
        allBillingAccounts.add(billing4);

        return allBillingAccounts;
    }

    public List<BillingAccountViewModel> getBillingAccountById(int id) {
        List<BillingAccountViewModel> allBillingAccounts = new LinkedList<BillingAccountViewModel>();
        BillingAccountViewModel billing1 = new BillingAccountViewModel(1, 1, "1", "1", "1", 0);
        BillingAccountViewModel billing2 = new BillingAccountViewModel(2, 2, "2", "2", "2", 0);
        BillingAccountViewModel billing3 = new BillingAccountViewModel(3, 3, "3", "3", "3", 0);
        BillingAccountViewModel billing4 = new BillingAccountViewModel(4, 1, "4", "4", "4", 0);

        allBillingAccounts.add(billing1);
        allBillingAccounts.add(billing2);
        allBillingAccounts.add(billing3);
        allBillingAccounts.add(billing4);

        List<BillingAccountViewModel> result = new LinkedList<>();

        for (int i = 0; i < allBillingAccounts.size(); i++) {
            if (allBillingAccounts.get(i).getId() == id)
                result.add(allBillingAccounts.get(i));
        }
        return result;
    }

    public List<BillingAccountViewModel> getBillingAccountByOwnerId(int id) {
        List<BillingAccountViewModel> allBillingAccounts = new LinkedList<BillingAccountViewModel>();
        BillingAccountViewModel billing1 = new BillingAccountViewModel(1, 1, "1", "1", "1", 0);
        BillingAccountViewModel billing2 = new BillingAccountViewModel(2, 2, "2", "2", "2", 0);
        BillingAccountViewModel billing3 = new BillingAccountViewModel(3, 3, "3", "3", "3", 0);
        BillingAccountViewModel billing4 = new BillingAccountViewModel(4, 1, "4", "4", "4", 0);

        allBillingAccounts.add(billing1);
        allBillingAccounts.add(billing2);
        allBillingAccounts.add(billing3);
        allBillingAccounts.add(billing4);

        List<BillingAccountViewModel> result = new LinkedList<>();

        for (int i = 0; i < allBillingAccounts.size(); i++) {
            if (allBillingAccounts.get(i).getOwnerId() == id)
                result.add(allBillingAccounts.get(i));
        }
        return result;
    }

    public boolean checkPasswordById(String password, int id) {
        List<BillingAccountViewModel> allBillingAccounts = new LinkedList<BillingAccountViewModel>();
        BillingAccountViewModel billing1 = new BillingAccountViewModel(1, 1, "1", "1", "1", 0);
        BillingAccountViewModel billing2 = new BillingAccountViewModel(2, 2, "2", "2", "2", 0);
        BillingAccountViewModel billing3 = new BillingAccountViewModel(3, 3, "3", "3", "3", 0);
        BillingAccountViewModel billing4 = new BillingAccountViewModel(4, 1, "4", "4", "4", 0);

        allBillingAccounts.add(billing1);
        allBillingAccounts.add(billing2);
        allBillingAccounts.add(billing3);
        allBillingAccounts.add(billing4);

        if (allBillingAccounts.get(id).getPassword().equals(password))
            return true;

        return false;
    }

    public BillingAccountViewModel saveBillingAccount(BillingAccountViewModel account) {
        return null;
    }

    public void deleteBillingAccountById(int id) {
        return;
    }
}
