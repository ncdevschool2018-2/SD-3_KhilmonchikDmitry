package by.training.nc.sd3.service.impl;

import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.repository.SubscriptionUnitRepository;
import by.training.nc.sd3.service.SubscriptionUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubscriptionUnitServiceImpl implements SubscriptionUnitService {

    private SubscriptionUnitRepository subscriptionUnitRepository;

    @Autowired
    public SubscriptionUnitServiceImpl(SubscriptionUnitRepository subscriptionUnitRepository) {
        this.subscriptionUnitRepository = subscriptionUnitRepository;
    }

    public Iterable<SubscriptionUnit> getSubscriptionUnits() {
        return this.subscriptionUnitRepository.findAll();
    }

    public SubscriptionUnit save(SubscriptionUnit subscriptionUnit) { return  this.subscriptionUnitRepository.save(subscriptionUnit); }

    @Override
    public void delete(Long id) {
        this.subscriptionUnitRepository.deleteById(id);
    }

    @Override
    public Iterable<SubscriptionUnit> getByBillingAccountId(Long ownerId) {
        return this.subscriptionUnitRepository.getSubscriptionUnitsByBillingAccountId(ownerId);
    }

    @Override
    public Iterable<SubscriptionUnit> getByUserId(Long userAccountId) {
        return this.subscriptionUnitRepository.getSubscriptionUnitsByUserId(userAccountId);
    }

    @Override
    public Optional<SubscriptionUnit> getById(Long id) {
        return this.subscriptionUnitRepository.findById(id);
    }
}
