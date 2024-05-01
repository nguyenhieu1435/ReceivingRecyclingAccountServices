package vn.edu.iuh.fit.secondary.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.secondary.enums.DeliveryStatus;
import vn.edu.iuh.fit.secondary.models.Device;
import vn.edu.iuh.fit.secondary.repositories.DeviceRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeviceService {
    private DeviceRepository deviceRepository;


    public Device save(Device device) {
        return deviceRepository.save(device);
    }

    public Optional<Device> getDeviceById(long id) {
        return deviceRepository.findById(id);
    }
    // paging
    public Page<Device> pagingDeviceByUsername(String email ,int page, int size) {
        Sort sort = Sort.by("deviceId").descending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return deviceRepository.findAllByCustomerID_EmailAndAcceptIsTrue(email, pageRequest);
    }

    public Page<Device> pagingDevicesByProcessStatus(DeliveryStatus deliveryStatus, int page, int size) {
        Sort sort = Sort.by("deviceId").descending();
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return deviceRepository.findAllByDelivery_Status(deliveryStatus, pageRequest);
    }
}
