package by.training.nc.sd3.repository;

import by.training.nc.sd3.entity.BillingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillingAccountRepository extends CrudRepository<BillingAccount, Long> {

    Iterable<BillingAccount> findByOwnerId(@Param("ownerId") Long ownerId);//getByNameAndAndPasswordAndCreditCardNumber
    Optional<BillingAccount> findByNameAndPasswordAndCreditCardNumber(@Param("name") String name,
                                                      @Param("password") String password,
                                                      @Param("creditCardNumber") String creditCardNumber);
}
