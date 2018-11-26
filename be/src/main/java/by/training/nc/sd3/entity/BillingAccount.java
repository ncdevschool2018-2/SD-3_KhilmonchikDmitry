package by.training.nc.sd3.entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_account")
public class BillingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ownerId", nullable = false)
    private UserAccount owner;
    private String creditCardNumber;
    private String name;
    private String password;
    private int money;

    public long getId() {
        return id;
    }

    public UserAccount getOwner() {
        return owner;
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
}
