package by.training.nc.sd3.models;

public class SubscriptionUnitViewModel {
    private int userId;
    private SubscriptionViewModel subscription;
    private int daysLeft;
    private boolean willBeRenewed;
    private boolean status;

    public SubscriptionUnitViewModel(int userId, SubscriptionViewModel subscription, int daysLeft, boolean willBeRenewed, boolean status) {
        this.userId = userId;
        this.subscription = subscription;
        this.daysLeft = daysLeft;
        this.willBeRenewed = willBeRenewed;
        this.status = status;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public SubscriptionViewModel getSubscription() {
        return subscription;
    }

    public void setSubscription(SubscriptionViewModel subscription) {
        this.subscription = subscription;
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
}
