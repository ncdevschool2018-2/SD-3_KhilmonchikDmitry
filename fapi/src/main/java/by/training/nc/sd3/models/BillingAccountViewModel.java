package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountViewModel {

    private int id;
    private int ownerId;
    private String creditCardNumber;
    private String name;
    private String password;
    private int money;

    public BillingAccountViewModel(int id, int ownerId, String creditCardNumber, String name, String password, int money) {
        this.ownerId = ownerId;
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
        this.creditCardNumber = creditCardNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOwnerId(int id) {
        this.ownerId = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
}
