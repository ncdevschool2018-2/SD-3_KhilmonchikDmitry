package by.training.nc.sd3.models;

public class SubscriptionUnitViewModel {
    private Long id;
    private Long userId;
    private SubscriptionViewModel subscription;
    private int daysLeft;
    private boolean willBeRenewed;
    private boolean status;

    public SubscriptionUnitViewModel() {
    }

    public SubscriptionUnitViewModel(Long id, Long userId, SubscriptionViewModel subscription,
                                     int daysLeft, boolean willBeRenewed, boolean status) {
        this.id = id;
        this.userId = userId;
        this.subscription = subscription;
        this.daysLeft = daysLeft;
        this.willBeRenewed = willBeRenewed;
        this.status = status;
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

    public SubscriptionViewModel getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionViewModel subscription) {
        this.subscription = subscription;
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

    @Override
    public String toString() {
        return "SubscriptionUnitViewModel{" +
                "userId=" + userId +
                ", subscription=" + subscription +
                ", daysLeft=" + daysLeft +
                ", willBeRenewed=" + willBeRenewed +
                ", status=" + status +
                '}';
    }
}
