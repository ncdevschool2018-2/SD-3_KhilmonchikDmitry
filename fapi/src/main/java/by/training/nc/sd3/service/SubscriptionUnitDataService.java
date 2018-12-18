package by.training.nc.sd3.service;

import by.training.nc.sd3.models.SubscriptionUnitViewModel;

import java.util.List;

public interface SubscriptionUnitDataService {

    List<SubscriptionUnitViewModel> getSubscriptionUnitsByUserId(Long id);

    void delete(Long id);

    SubscriptionUnitViewModel save(SubscriptionUnitViewModel subscriptionUnitViewModel);

    SubscriptionUnitViewModel changeStatus(SubscriptionUnitViewModel subscriptionUnitViewModel);
}
