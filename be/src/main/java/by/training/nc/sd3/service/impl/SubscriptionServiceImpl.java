package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.Subscription;
import by.training.nc.sd3.repository.SubscriptionRepository;
import by.training.nc.sd3.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Iterable<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }

    public Iterable<Subscription> getSubscriptionsByCategory(Long category) {
        Iterable<Subscription> subscriptions = getSubscriptions();
        Iterable<Subscription> responseSubscriptions = new LinkedList<>();
        subscriptions.forEach(
                subscription -> {
                    if(subscription.getCategory() == category)
                        ((LinkedList<Subscription>) responseSubscriptions).add(subscription);
                }
        );
        return responseSubscriptions;
    }

    public Subscription getSubscriptionsByName(String name) {
        Iterable<Subscription> subscriptions = getSubscriptions();
        AtomicReference<Subscription> responseSubscription = new AtomicReference<>();
        subscriptions.forEach(
                subscription -> {
                    if(subscription.getName().equals(name))
                        responseSubscription.set(subscription);
                }
        );
        return responseSubscription.get();
    }

    @Override
    public Subscription save(Subscription subscription) {
        return this.subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription ban(Long id) {
        Optional<Subscription> subscriptionOptional = this.subscriptionRepository.findById(id);
        if(subscriptionOptional.isPresent()) {
            Subscription subscription = subscriptionOptional.get();
            subscription.setIsBanned(true);
            return this.subscriptionRepository.save(subscription);
        }
        return null;
    }

    @Override
    public Subscription unBan(Long id) {
        Optional<Subscription> subscriptionOptional = this.subscriptionRepository.findById(id);
        if(subscriptionOptional.isPresent()) {
            Subscription subscription = subscriptionOptional.get();
            subscription.setIsBanned(false);
            return this.subscriptionRepository.save(subscription);
        }
        return null;
    }

}
