package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountViewModel {

    public final int id;
    public final int ownerId;
    public final String creditCardNumber;
    public final String name;
    public final String password;
    public int money;

    public BillingAccountViewModel(int id, int ownerId, String creditCardNumber, String name, String password, int money) {
        this.ownerId = ownerId;
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
        this.creditCardNumber = creditCardNumber;
    }
}
