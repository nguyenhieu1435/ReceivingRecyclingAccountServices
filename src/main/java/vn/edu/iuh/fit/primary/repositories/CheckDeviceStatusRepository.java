package vn.edu.iuh.fit.primary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.primary.models.CheckDeviceStatus;

public interface CheckDeviceStatusRepository extends JpaRepository<CheckDeviceStatus, Long> {
}