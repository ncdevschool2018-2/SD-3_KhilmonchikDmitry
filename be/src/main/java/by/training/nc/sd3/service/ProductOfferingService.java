package by.training.nc.sd3.service;


import by.training.nc.sd3.entity.ProductOffering;

import java.util.Optional;

public interface ProductOfferingService {

    Iterable<ProductOffering> getSubscriptions();
    Optional<ProductOffering> getSubscriptionById(Long id);
    Iterable<ProductOffering> getSubscriptionsByCategory(Long category);
    ProductOffering getSubscriptionsByName(String name);
    ProductOffering save(ProductOffering productOffering);
    ProductOffering ban(Long id);
    ProductOffering unBan(Long id);
}
