package by.training.nc.sd3.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int category;
    private int perMonth;
    private int perThreeMonths;
    private int perYear;
    private boolean isBanned;

    public Subscription() {
    }

    public Subscription(String name, String description,
                        int category, int perMonth, int perThreeMonths,
                        int perYear, boolean isBanned) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.perMonth = perMonth;
        this.perThreeMonths = perThreeMonths;
        this.perYear = perYear;
        this.isBanned = isBanned;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = Categories.valueOf(category).ordinal();
    }

    public int getPerMonth() {
        return perMonth;
    }

    public void setPerMonth(int perMonth) {
        this.perMonth = perMonth;
    }

    public int getPerThreeMonths() {
        return perThreeMonths;
    }

    public void setPerThreeMonths(int perThreeMonths) {
        this.perThreeMonths = perThreeMonths;
    }

    public int getPerYear() {
        return perYear;
    }

    public void setPerYear(int perYear) {
        this.perYear = perYear;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean banned) {
        isBanned = banned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id &&
                perMonth == that.perMonth &&
                perThreeMonths == that.perThreeMonths &&
                perYear == that.perYear &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, category, perMonth, perThreeMonths, perYear);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category + '\'' +
                ", perMonth=" + perMonth + '\'' +
                ", perThreeMonths=" + perThreeMonths + '\'' +
                ", perYear=" + perYear + '\'' +
                '}';
    }
}
