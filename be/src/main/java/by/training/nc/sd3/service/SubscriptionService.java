package by.training.nc.sd3.service;


import by.training.nc.sd3.entity.Subscription;

import java.util.Optional;

public interface SubscriptionService {

    Iterable<Subscription> getSubscriptions();
    Optional<Subscription> getSubscriptionById(Long id);
    Iterable<Subscription> getSubscriptionsByCategory(Long category);
    Subscription getSubscriptionsByName(String name);
}
