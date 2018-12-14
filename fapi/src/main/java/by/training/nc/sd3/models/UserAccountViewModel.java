package by.training.nc.sd3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel {

    private Long id;
    private String name;
    private String password;
    private String email;
    private boolean isAdmin;
    private boolean isBanned;

    public UserAccountViewModel() {
    }

    public UserAccountViewModel(Long id, String name, String password, String email, boolean isAdmin, boolean isBanned) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isBanned = isBanned;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setIsBanned(boolean banned) {
        isBanned = banned;
    }

    public boolean getIsBanned() {
        return isBanned;
    }
}
