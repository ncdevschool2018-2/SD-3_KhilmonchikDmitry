package by.training.nc.sd3.models;

import java.util.Date;

public class SubscriptionUnitViewModel {
    private int userId;
    private int subscriptionId;
    private int billingAccountId;
    private int daysLeft;
    private boolean willBeRenewed;
    private boolean status;
    private Date creationDate;
    private Date writeOffDate;

    public SubscriptionUnitViewModel() {
    }

    public SubscriptionUnitViewModel(int userId, int subscriptionId, int billingAccountId, int daysLeft, boolean willBeRenewed, boolean status, Date creationDate, Date writeOffDate) {
        this.userId = userId;
        this.subscriptionId = subscriptionId;
        this.billingAccountId = billingAccountId;
        this.daysLeft = daysLeft;
        this.willBeRenewed = willBeRenewed;
        this.status = status;
        this.creationDate = creationDate;
        this.writeOffDate = writeOffDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public int getBillingAccountId() {
        return billingAccountId;
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
