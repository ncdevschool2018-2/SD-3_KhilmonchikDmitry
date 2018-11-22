package by.training.nc.sd3.service;

import by.training.nc.sd3.entity.SubscriptionUnit;

public interface SubscriptionUnitService {

    Iterable<SubscriptionUnit> getSubscriptionUnits();

    SubscriptionUnit save(SubscriptionUnit subscriptionUnit);

    void delete(Long id);

    Iterable<SubscriptionUnit> getByBillingAccountId(Long ownerId);

    Iterable<SubscriptionUnit> getByUserId(Long userAccountId);

}
