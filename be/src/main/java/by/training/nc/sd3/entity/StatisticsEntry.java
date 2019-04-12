package by.training.nc.sd3.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "payments")
public class StatisticsEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long billingAccountId;
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Subscription serviceId;
    private Long sum;
    @CreatedDate
    private LocalDateTime date;

    public StatisticsEntry() {
    }

    public StatisticsEntry(Long billingAccountId, Subscription subscription, Long sum, LocalDateTime date) {
        this.billingAccountId = billingAccountId;
        this.serviceId = subscription;
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

    public Subscription getServiceId() {
        return serviceId;
    }

    public void setServiceId(Subscription subscription) {
        this.serviceId = subscription;
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
