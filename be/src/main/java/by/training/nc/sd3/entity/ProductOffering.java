package by.training.nc.sd3.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_offering")
public class ProductOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int category;
    private int cost;
    private boolean isBanned;

    public ProductOffering() {
    }

    public ProductOffering(String name, String description,
                           int category, int perMonth, int perThreeMonths,
                           int perYear, boolean isBanned) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.cost = perMonth;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
        ProductOffering that = (ProductOffering) o;
        return id == that.id &&
                cost == that.cost &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, category, cost);
    }

    @Override
    public String toString() {
        return "ProductOffering{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category + '\'' +
                ", cost=" + cost + '\'' +
                '}';
    }
}
