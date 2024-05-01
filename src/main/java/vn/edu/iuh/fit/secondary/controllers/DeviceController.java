package vn.edu.iuh.fit.secondary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.secondary.dto.DeviceFilteredResponse;
import vn.edu.iuh.fit.secondary.enums.DeliveryStatus;
import vn.edu.iuh.fit.secondary.models.Device;
import vn.edu.iuh.fit.secondary.services.DeliveryService;
import vn.edu.iuh.fit.secondary.services.DeviceService;

import java.util.Optional;

@RestController
@RequestMapping("/api/device")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DeviceController {
    private DeviceService deviceService;
    private DeliveryService deliveryService;


    @GetMapping("/filter-devices-by-status")
    public ResponseEntity<?> filterDevicesByStatus(@RequestParam Optional<Integer> pageNo,
                                                   @RequestParam Optional<Integer> sizeNo,
                                                   @RequestParam int status){
        int finalPageNo = pageNo.orElse(1);
        int finalSizeNo = sizeNo.orElse(5);
        DeliveryStatus deliveryStatus = DeliveryStatus.fromValue(status);
        Page<Device> devices = deviceService.pagingDevicesByProcessStatus(deliveryStatus, finalPageNo - 1, finalSizeNo);

        DeviceFilteredResponse deviceFilteredResponse = new DeviceFilteredResponse();
        deviceFilteredResponse.setPageNo(finalPageNo);
        deviceFilteredResponse.setSizeNo(finalSizeNo);
        deviceFilteredResponse.setDevices(devices.getContent());

        return ResponseEntity.ok(deviceFilteredResponse);
    }
}
