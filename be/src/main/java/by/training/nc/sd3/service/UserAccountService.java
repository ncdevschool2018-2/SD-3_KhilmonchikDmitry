package by.training.nc.sd3.service;
import java.util.Optional;

public interface UserAccountService {

    Optional<by.training.nc.sd3.entity.UserAccount> getUserAccount(String name, String password);
    Optional<by.training.nc.sd3.entity.UserAccount> getUserAccountById(Long id);
}
