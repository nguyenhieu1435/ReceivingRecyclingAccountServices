package vn.edu.iuh.fit;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import vn.edu.iuh.fit.primary.enums.AdminAccountStatus;
import vn.edu.iuh.fit.primary.models.AdminAccount;
import vn.edu.iuh.fit.primary.repositories.AdminAccountRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class ReceivingRecyclingAccountServicesApplication implements CommandLineRunner {
    @Autowired
    private AdminAccountRepository adminAccountRepository;
    public static void main(String[] args) {
        SpringApplication.run(ReceivingRecyclingAccountServicesApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        AdminAccount adminAccount = new AdminAccount();
//        adminAccount.setUsername("admin");
//        adminAccount.setPassword(BCrypt.hashpw("123123", BCrypt.gensalt()));
//        adminAccount.setDob(LocalDateTime.of(2000, 12, 10, 12, 0));
//        adminAccount.setGender("male");
//        adminAccount.setStatus(AdminAccountStatus.ACTIVE);
//        adminAccount.setFullName("Nguyễn Văn Hiếu");
//        adminAccount.setCreateAt(LocalDateTime.now());
//        adminAccountRepository.save(adminAccount);
    }
}
