package by.training.nc.sd3.service;

import by.training.nc.sd3.models.SubscriptionUnitViewModel;

import java.util.List;

public interface SubscriptionUnitDataService {

    public List<SubscriptionUnitViewModel> getSubscriptionUnitsByUserId(Long id);

    public void delete(Long id);

    public SubscriptionUnitViewModel save(SubscriptionUnitViewModel subscriptionUnitViewModel);

    public SubscriptionUnitViewModel changeStatus(SubscriptionUnitViewModel subscriptionUnitViewModel);
}
