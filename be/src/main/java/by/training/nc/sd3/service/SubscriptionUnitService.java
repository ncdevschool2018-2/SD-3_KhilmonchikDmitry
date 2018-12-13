package by.training.nc.sd3.service;

import by.training.nc.sd3.entity.SubscriptionUnit;

import java.util.Optional;

public interface SubscriptionUnitService {

    Iterable<SubscriptionUnit> getSubscriptionUnits();

    SubscriptionUnit save(SubscriptionUnit subscriptionUnit);

    void delete(Long id);

    Iterable<SubscriptionUnit> getByBillingAccountId(Long ownerId);

    Iterable<SubscriptionUnit> getByUserId(Long userAccountId);

    Optional<SubscriptionUnit> getById(Long id);

    SubscriptionUnit changeStatus(SubscriptionUnit subscriptionUnit);

    SubscriptionUnit update(SubscriptionUnit subscriptionUnit);

}
