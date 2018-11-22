package by.training.nc.sd3.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "subscription_unit")
public class SubscriptionUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long subscriptionId;
    private long billingAccountId;
    private int daysLeft;
    private boolean willBeRenewed;
    private boolean status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date writeOffDate;

    public SubscriptionUnit() {
    }

    public SubscriptionUnit(long userId, long subscriptionId, int daysLeft, boolean willBeRenewed, boolean status,
                            Time creationDate, long billingAccountId, Time writeOffDate) {
        this.userId = userId;
        this.subscriptionId = subscriptionId;
        this.billingAccountId = billingAccountId;
        this.daysLeft = daysLeft;
        this.willBeRenewed = willBeRenewed;
        this.status = status;
        this.creationDate = creationDate;
        this.writeOffDate = writeOffDate;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getSubscriptionId() {
        return subscriptionId;
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

    public long getBillingAccountId() {
        return billingAccountId;
    }

    public Date getWriteOffDate() {
        return writeOffDate;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public void setWillBeRenewed(boolean willBeRenewed) {
        this.willBeRenewed = willBeRenewed;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setWriteOffDate(Date writeOffDate) {
        this.writeOffDate = writeOffDate;
    }
}
