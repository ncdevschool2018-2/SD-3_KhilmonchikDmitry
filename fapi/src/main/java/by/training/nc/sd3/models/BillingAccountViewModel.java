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
    private boolean isBanned;

    public BillingAccountViewModel(Long id, Long ownerId, String creditCardNumber, String name, String password, int money, boolean isBanned) {
        this.id = id;
        this.ownerId = ownerId;
        this.creditCardNumber = creditCardNumber;
        this.name = name;
        this.password = password;
        this.money = money;
        this.isBanned = isBanned;
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

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
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
