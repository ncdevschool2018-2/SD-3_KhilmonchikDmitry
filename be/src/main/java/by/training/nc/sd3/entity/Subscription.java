package by.training.nc.sd3.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int category;
    private int perMonth;
    private int perThreeMonths;
    private int perYear;

    public Subscription() {
    }

    public Subscription(long id, String name, String description, int category, int perMonth, int perThreeMonths, int perYear) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.perMonth = perMonth;
        this.perThreeMonths = perThreeMonths;
        this.perYear = perYear;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCategory() {
        return category;
    }

    public int getPerMonth() {
        return perMonth;
    }

    public int getPerThreeMonths() {
        return perThreeMonths;
    }

    public int getPerYear() {
        return perYear;
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
