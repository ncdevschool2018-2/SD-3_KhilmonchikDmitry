package by.training.nc.sd3.entity;

import javax.persistence.*;

@Entity
@Table(name = "billing_account")
public class BillingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long ownerId;
    private String creditCardNumber;
    private String name;
    private String password;
    private int money;

    public BillingAccount() {
    }

    public BillingAccount(long ownerId, String creditCardNumber, String name, String password, int money) {
        this.ownerId = ownerId;
        this.creditCardNumber = creditCardNumber;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public long getOwnerId() {
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
}