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

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Subscription getSubscription() {
        return subscription;
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

    public BillingAccount getBillingAccount() {
        return billingAccount;
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

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
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
