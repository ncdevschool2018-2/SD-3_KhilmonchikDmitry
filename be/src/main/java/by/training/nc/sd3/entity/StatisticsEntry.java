package by.training.nc.sd3.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class StatisticsEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long billingAccountId;
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private ProductOffering serviceId;
    private Long sum;
    @CreatedDate
    private LocalDateTime date;

    public StatisticsEntry() {
    }

    public StatisticsEntry(Long billingAccountId, ProductOffering productOffering, Long sum, LocalDateTime date) {
        this.billingAccountId = billingAccountId;
        this.serviceId = productOffering;
        this.sum = sum;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(Long billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public ProductOffering getServiceId() {
        return serviceId;
    }

    public void setServiceId(ProductOffering productOffering) {
        this.serviceId = productOffering;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
