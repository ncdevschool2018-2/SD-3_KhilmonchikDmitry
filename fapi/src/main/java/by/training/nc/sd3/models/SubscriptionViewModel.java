package by.training.nc.sd3.models;

public class SubscriptionViewModel {
    public final String name;
    public final String description;
    public final int perMonth;
    public final int perThreeMonth;
    public final int perYear;

    public SubscriptionViewModel(String name, String description, int perMonth, int perThreeMonth, int perYear) {
        this.name = name;
        this.description = description;
        this.perMonth = perMonth;
        this.perThreeMonth = perThreeMonth;
        this.perYear = perYear;
    }
}
