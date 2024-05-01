package vn.edu.iuh.fit.primary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.primary.models.AdminAccount;

public interface AdminAccountRepository extends JpaRepository<AdminAccount, String> {
}