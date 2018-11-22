package by.training.nc.sd3.repository;

import by.training.nc.sd3.entity.SubscriptionUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionUnitRepository extends CrudRepository<SubscriptionUnit, Long> {

    Iterable<SubscriptionUnit> getSubscriptionUnitsByBillingAccountId(@Param("billingAccountId") Long billingAccountId);

}
