package vn.edu.iuh.fit.primary.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.primary.models.CheckDeviceStatus;
import vn.edu.iuh.fit.primary.repositories.CheckDeviceStatusRepository;

@Service
@AllArgsConstructor
public class CheckDeviceStatusService {
    private CheckDeviceStatusRepository checkDeviceStatusRepository;

    public CheckDeviceStatus addCheckDeviceStatus(CheckDeviceStatus checkDeviceStatus){
        return checkDeviceStatusRepository.save(checkDeviceStatus);
    }
}
