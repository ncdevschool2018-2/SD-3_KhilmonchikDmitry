package by.training.nc.sd3.service;

import by.training.nc.sd3.entity.ProductInstance;

import java.util.Optional;

public interface ProductInstanceService {

    Iterable<ProductInstance> getSubscriptionUnits();

    ProductInstance save(ProductInstance productInstance);

    void delete(Long id);

    Iterable<ProductInstance> getByBillingAccountId(Long ownerId);

    Iterable<ProductInstance> getByUserId(Long userAccountId);

    Optional<ProductInstance> getById(Long id);

    ProductInstance changeStatus(ProductInstance productInstance);

    ProductInstance update(ProductInstance productInstance);

}
