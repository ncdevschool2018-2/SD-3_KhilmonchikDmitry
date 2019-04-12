package by.training.nc.sd3.models;

import java.time.LocalDateTime;

public class StatisticsEntryViewModel {

    private Long id;
    private Long billingAccountId;
    private SubscriptionViewModel serviceId;
    private Long sum;
    private LocalDateTime date;

    public StatisticsEntryViewModel() {
    }

    public StatisticsEntryViewModel(Long billingAccountId, SubscriptionViewModel subscription, Long sum, LocalDateTime date) {
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

    public SubscriptionViewModel getServiceId() {
        return serviceId;
    }

    public void setServiceId(SubscriptionViewModel subscription) {
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
