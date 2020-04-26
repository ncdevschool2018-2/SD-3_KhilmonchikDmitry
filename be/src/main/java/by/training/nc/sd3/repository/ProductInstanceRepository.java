package by.training.nc.sd3.repository;

import by.training.nc.sd3.entity.ProductInstance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInstanceRepository extends CrudRepository<ProductInstance, Long> {

    Iterable<ProductInstance> getSubscriptionUnitsByBillingAccountId(@Param("billingAccountId") Long billingAccountId);

    Iterable<ProductInstance> getSubscriptionUnitsByUserId(@Param("userId") Long userAccountId);

    Integer countByUserId(@Param("userId") Long userAccountId);

    @Override
    void deleteById(Long aLong);
}
