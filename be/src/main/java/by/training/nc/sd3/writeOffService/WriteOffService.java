package by.training.nc.sd3.writeOffService;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.StatisticsEntry;
import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.repository.StatisticsEntryRepository;
import by.training.nc.sd3.repository.SubscriptionUnitRepository;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.SubscriptionUnitService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Component
public class WriteOffService {

    private SubscriptionUnitService subscriptionUnitService;
    private BillingAccountService billingAccountService;
    private StatisticsEntryRepository statisticsEntryRepository;
    private static final int MONTH = 1000;

    public WriteOffService(SubscriptionUnitService subscriptionUnitService,
                           BillingAccountService billingAccountService,
                           StatisticsEntryRepository statisticsEntryRepository) {
        this.subscriptionUnitService = subscriptionUnitService;
        this.billingAccountService = billingAccountService;
        this.statisticsEntryRepository = statisticsEntryRepository;
    }

    private void pay(SubscriptionUnit subscriptionUnit) {
        if (subscriptionUnit.getBillingAccount() != null) {
            Optional<BillingAccount> billingAccountOptional = billingAccountService.getById(subscriptionUnit.getBillingAccount().getId());
            if (billingAccountOptional.isPresent()) {
                BillingAccount billingAccount = billingAccountOptional.get();
                int fee = subscriptionUnit.getSubscription().getPerMonth();
                if (billingAccount.getMoney() - fee > 0) {
                    billingAccount.setMoney(billingAccount.getMoney() - fee);
                    subscriptionUnit.setWillBeRenewed(true);
                    subscriptionUnit.setDaysLeft(30);
                    StatisticsEntry statisticsEntry = new StatisticsEntry();
                    statisticsEntry.setBillingAccountId(billingAccount.getId());
                    statisticsEntry.setDate(LocalDateTime.now());
                    statisticsEntry.setSum((long) fee);
                    statisticsEntry.setServiceId(subscriptionUnit.getSubscription());
                    this.statisticsEntryRepository.save(statisticsEntry);
                } else {
                    subscriptionUnit.setWillBeRenewed(false);
                }
                this.billingAccountService.save(billingAccount);
            } else {
                subscriptionUnit.setWillBeRenewed(false);
            }
        } else {
            subscriptionUnit.setWillBeRenewed(false);
        }
    }

    @Scheduled(fixedDelay = MONTH)
    public void writeOff() {
        Iterable<SubscriptionUnit> subscriptionUnits = subscriptionUnitService.getSubscriptionUnits();
        subscriptionUnits.forEach(
                subscriptionUnit -> {
                    if (subscriptionUnit.isStatus()) {
                        Date date = new Date();
                        if (date.getTime() - subscriptionUnit.getWriteOffDate().getTime() >= MONTH
                                && subscriptionUnit.getDaysLeft() > 0 && subscriptionUnit.isStatus()) {
                            subscriptionUnit.setDaysLeft(subscriptionUnit.getDaysLeft() - 1);
                            subscriptionUnit.setWriteOffDate(date);
                        }
                        if (subscriptionUnit.getDaysLeft() == 0 && subscriptionUnit.isStatus()) {
                            pay(subscriptionUnit);
                        }
                        this.subscriptionUnitService.update(subscriptionUnit);
                    }
                }
        );
    }
}
