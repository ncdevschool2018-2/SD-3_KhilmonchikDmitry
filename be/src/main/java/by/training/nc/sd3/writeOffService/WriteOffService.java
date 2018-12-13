package by.training.nc.sd3.writeOffService;

import by.training.nc.sd3.entity.BillingAccount;
import by.training.nc.sd3.entity.Subscription;
import by.training.nc.sd3.entity.SubscriptionUnit;
import by.training.nc.sd3.service.BillingAccountService;
import by.training.nc.sd3.service.SubscriptionService;
import by.training.nc.sd3.service.SubscriptionUnitService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class WriteOffService {

    private SubscriptionUnitService subscriptionUnitService;
    private BillingAccountService billingAccountService;
    private SubscriptionService subscriptionService;

    public WriteOffService(SubscriptionUnitService subscriptionUnitService,
                           BillingAccountService billingAccountService,
                           SubscriptionService subscriptionService) {
        this.subscriptionUnitService = subscriptionUnitService;
        this.billingAccountService = billingAccountService;
        this.subscriptionService = subscriptionService;
    }

    @Scheduled(fixedDelay = 5000)
    public void writeOff() {
        Iterable<SubscriptionUnit> subscriptionUnits = subscriptionUnitService.getSubscriptionUnits();
        subscriptionUnits.forEach(
                subscriptionUnit -> {
                    if (subscriptionUnit.isWillBeRenewed()) {
                        Date date = new Date();
                        if (date.getTime() - subscriptionUnit.getWriteOffDate().getTime() >= 1000
                                && subscriptionUnit.getDaysLeft() > 0) {
                            subscriptionUnit.setDaysLeft(subscriptionUnit.getDaysLeft() - 1);
                            subscriptionUnit.setWriteOffDate(date);
                            System.out.println(subscriptionUnit.getDaysLeft());
                        }
                        if (subscriptionUnit.getDaysLeft() == 0 && subscriptionUnit.isWillBeRenewed() && subscriptionUnit.isStatus()) {
                            Optional<BillingAccount> billingAccountOptional = billingAccountService.getById(subscriptionUnit.getBillingAccount().getId());
                            if (billingAccountOptional.isPresent()) {
                                BillingAccount billingAccount = billingAccountOptional.get();
                                int fee = subscriptionUnit.getSubscription().getPerMonth();
                                if (billingAccount.getMoney() - fee > 0) {
                                    billingAccount.setMoney(billingAccount.getMoney() - fee);
                                    subscriptionUnit.setDaysLeft(30);
                                } else {
                                    subscriptionUnit.setWillBeRenewed(false);
                                }
                                this.billingAccountService.save(billingAccount);
                                System.out.println(billingAccountOptional.get().getMoney());
                            }
                        }
                        this.subscriptionUnitService.update(subscriptionUnit);
                    }
                }
        );
    }
}
