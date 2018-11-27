package by.training.nc.sd3.service;

import by.training.nc.sd3.models.SubscriptionViewModel;

import java.util.List;

public interface SubscriptionDataService {
    List<SubscriptionViewModel> getAll();
    SubscriptionViewModel getSubscriptionById(Long id);
    List<SubscriptionViewModel> getSubscriptionByCategory(String category);
    SubscriptionViewModel getSubscriptionByName(String name);
}
