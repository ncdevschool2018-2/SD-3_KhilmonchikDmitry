package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel {

    public final int id;
    public final String name;
    public final String password;
    public final String email;

    public UserAccountViewModel(int id, String name, String password, String email) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
