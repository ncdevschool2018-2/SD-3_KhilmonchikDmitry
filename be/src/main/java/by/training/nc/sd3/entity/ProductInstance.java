package by.training.nc.sd3.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_instance")
public class ProductInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @ManyToOne
    @JoinColumn(name = "subscriptionId", nullable = false)
    private ProductOffering productOffering;
    @ManyToOne
    @JoinColumn(name = "billingAccountId", nullable = false)
    private BillingAccount billingAccount;
    private boolean status;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationDate;

    public ProductInstance() {
    }

    public ProductInstance(Long userId, ProductOffering productOffering, BillingAccount billingAccount, int daysLeft,
                           boolean willBeRenewed, boolean status, Date creationDate, Date writeOffDate) {
        this.userId = userId;
        this.productOffering = productOffering;
        this.billingAccount = billingAccount;
        this.status = status;
        this.creationDate = creationDate;
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

    public ProductOffering getProductOffering() {
        return productOffering;
    }

    public void setProductOffering(ProductOffering productOffering) {
        this.productOffering = productOffering;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
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

    @Override
    public String toString() {
        return "ProductInstance{" +
                "id=" + id +
                ", userId=" + userId +
                ", productOffering=" + productOffering +
                ", billingAccount=" + billingAccount +
                ", status=" + status +
                ", creationDate=" + creationDate +
                '}';
    }
}
