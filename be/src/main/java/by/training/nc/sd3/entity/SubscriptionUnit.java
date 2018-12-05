package by.training.nc.sd3.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscription_unit")
public class SubscriptionUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "subscriptionId", nullable = false)
    private Subscription subscription;
    @ManyToOne
    @JoinColumn(name = "billingAccountId", nullable = false)
    private BillingAccount billingAccount;
    private int daysLeft;
    private boolean willBeRenewed;
    private boolean status;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date writeOffDate;

    public SubscriptionUnit() {
    }

    public SubscriptionUnit(Long userId, Subscription subscription, BillingAccount billingAccount, int daysLeft,
                            boolean willBeRenewed, boolean status, Date creationDate, Date writeOffDate) {
        this.userId = userId;
        this.subscription = subscription;
        this.billingAccount = billingAccount;
        this.daysLeft = daysLeft;
        this.willBeRenewed = willBeRenewed;
        this.status = status;
        this.creationDate = creationDate;
        this.writeOffDate = writeOffDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public boolean isWillBeRenewed() {
        return willBeRenewed;
    }

    public void setWillBeRenewed(boolean willBeRenewed) {
        this.willBeRenewed = willBeRenewed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getWriteOffDate() {
        return writeOffDate;
    }

    public void setWriteOffDate(Date writeOffDate) {
        this.writeOffDate = writeOffDate;
    }

    @Override
    public String toString() {
        return "SubscriptionUnit{" +
                "id=" + id +
                ", userId=" + userId +
                ", subscription=" + subscription +
                ", billingAccount=" + billingAccount +
                ", daysLeft=" + daysLeft +
                ", willBeRenewed=" + willBeRenewed +
                ", status=" + status +
                ", creationDate=" + creationDate +
                ", writeOffDate=" + writeOffDate +
                '}';
    }
}
