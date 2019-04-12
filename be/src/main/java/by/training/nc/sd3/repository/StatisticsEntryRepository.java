package by.training.nc.sd3.repository;

import by.training.nc.sd3.entity.StatisticsEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Month;

@Repository
public interface StatisticsEntryRepository extends CrudRepository<StatisticsEntry, Long>{
    Iterable<StatisticsEntry> findByBillingAccountId(Long billingAccountId);
    Iterable<StatisticsEntry> findByServiceIdCategory(int category);
    //Iterable<StatisticsEntry> findByDateMonth(Month date_month);
}
