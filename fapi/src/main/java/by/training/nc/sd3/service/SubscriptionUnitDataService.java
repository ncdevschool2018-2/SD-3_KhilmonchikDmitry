package by.training.nc.sd3.service;

import by.training.nc.sd3.models.SubscriptionUnitViewModel;

import java.util.List;

public interface SubscriptionUnitDataService {

    public List<SubscriptionUnitViewModel> getSubscriptionUnitsById(int id);
}
