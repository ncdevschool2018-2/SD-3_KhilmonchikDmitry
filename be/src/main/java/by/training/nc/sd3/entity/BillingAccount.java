package by.training.nc.sd3.entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_account")
public class BillingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ownerId;
    private String creditCardNumber;
    private String name;
    private String password;
    private int money;

    public Long getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
