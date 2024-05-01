package vn.edu.iuh.fit.primary.services;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.primary.models.AdminAccount;
import vn.edu.iuh.fit.primary.repositories.AdminAccountRepository;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AdminService {
    private AdminAccountRepository adminAccountRepository;

    public Optional<AdminAccount> handleLogin(String username, String password){
        AdminAccount adminAccount = adminAccountRepository.findById(username).orElse(null);
        if(adminAccount == null){
            return Optional.empty();
        }
        boolean isMatch = BCrypt.checkpw(password, adminAccount.getPassword());
        if(!isMatch){
            return Optional.empty();
        }
        return Optional.of(adminAccount);
    }
}
