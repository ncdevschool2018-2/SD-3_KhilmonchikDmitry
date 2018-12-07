package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountViewModel {

    private Long id;
    private Long ownerId;
    private String creditCardNumber;
    private String name;
    private String password;
    private int money;

    public BillingAccountViewModel(Long id, Long ownerId, String creditCardNumber, String name, String password, int money) {
        this.ownerId = ownerId;
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
        this.creditCardNumber = creditCardNumber;
    }

    public BillingAccountViewModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setOwnerId(Long id) {
        this.ownerId = id;
    }

    public Long getOwnerId() {
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

    @Override
    public String toString() {
        return "BillingAccountViewModel{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
