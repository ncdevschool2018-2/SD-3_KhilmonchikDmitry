package by.training.nc.sd3.models;

public class SubscriptionViewModel {
    private Long id;
    private String name;
    private String description;
    private int category;
    private int perMonth;
    private int perThreeMonth;
    private int perYear;

    public SubscriptionViewModel() {
    }

    public SubscriptionViewModel(Long id, String name, String description, int category, int perMonth, int perThreeMonth, int perYear) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.perMonth = perMonth;
        this.perThreeMonth = perThreeMonth;
        this.perYear = perYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return Categories.values()[category];
    }

    public void setCategory(Categories category) {
        this.category = category.ordinal();
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
