package by.training.nc.sd3.models;

public class SubscriptionViewModel {
    private int id;
    private String name;
    private String description;
    private Categories category;
    private int perMonth;
    private int perThreeMonth;
    private int perYear;

    public SubscriptionViewModel(int id, String name, String description, Categories category, int perMonth, int perThreeMonth, int perYear) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.perMonth = perMonth;
        this.perThreeMonth = perThreeMonth;
        this.perYear = perYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public int getPerMonth() {
        return perMonth;
    }

    public void setPerMonth(int perMonth) {
        this.perMonth = perMonth;
    }

    public int getPerThreeMonth() {
        return perThreeMonth;
    }

    public void setPerThreeMonth(int perThreeMonth) {
        this.perThreeMonth = perThreeMonth;
    }

    public int getPerYear() {
        return perYear;
    }

    public void setPerYear(int perYear) {
        this.perYear = perYear;
    }

    public String getDescription() {
        return description;
    }
}
