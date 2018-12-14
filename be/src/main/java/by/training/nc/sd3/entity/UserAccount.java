package by.training.nc.sd3.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long activeBillingAccountId;
    private String name;
    private String password;
    private String email;
    private boolean isAdmin;
    private boolean isBanned;

    public UserAccount() {
    }

    public UserAccount(Long activeBillingAccountId, String name, String password, String email, boolean isAdmin, boolean isBanned) {
        this.activeBillingAccountId = activeBillingAccountId;
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

    public Long getActiveBillingAccountId() {
        return activeBillingAccountId;
    }

    public void setActiveBillingAccountId(Long activeBillingAccountId) {
        this.activeBillingAccountId = activeBillingAccountId;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean banned) {
        isBanned = banned;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", activeBillingAccountId=" + activeBillingAccountId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
