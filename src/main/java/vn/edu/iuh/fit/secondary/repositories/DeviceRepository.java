package vn.edu.iuh.fit.secondary.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.secondary.enums.DeliveryStatus;
import vn.edu.iuh.fit.secondary.models.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {


    public Page<Device> findAllByCustomerID_EmailAndAcceptIsTrue(String email, Pageable pageable);

    Page<Device> findAllByDelivery_Status(DeliveryStatus deliveryStatus, Pageable pageable);
}