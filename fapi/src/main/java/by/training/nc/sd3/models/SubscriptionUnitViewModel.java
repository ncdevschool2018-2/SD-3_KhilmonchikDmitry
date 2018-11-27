package by.training.nc.sd3.models;

import java.util.Date;

public class SubscriptionUnitViewModel {
    private Long userId;
    private SubscriptionViewModel subscription;
    private BillingAccountViewModel billingAccount;
    private int daysLeft;
    private boolean willBeRenewed;
    private boolean status;
    private Date creationDate;
    private Date writeOffDate;

    public SubscriptionUnitViewModel() {
    }

    public Long getUserId() {
        return userId;
    }

    public SubscriptionViewModel getSubscriptionId() {
        return subscription;
    }

    public BillingAccountViewModel getBillingAccountId() {
        return billingAccount;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public boolean isWillBeRenewed() {
        return willBeRenewed;
    }

    public boolean isStatus() {
        return status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getWriteOffDate() {
        return writeOffDate;
    }
}
