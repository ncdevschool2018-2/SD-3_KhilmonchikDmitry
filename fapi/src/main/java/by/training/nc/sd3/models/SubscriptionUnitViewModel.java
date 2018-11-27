package by.training.nc.sd3.models;

public class SubscriptionUnitViewModel {
    private Long userId;
    private SubscriptionViewModel subscription;
    private int daysLeft;
    private boolean willBeRenewed;
    private boolean status;

    public SubscriptionUnitViewModel() {
    }

    public Long getUserId() {
        return userId;
    }

    public SubscriptionViewModel getSubscriptionId() {
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
