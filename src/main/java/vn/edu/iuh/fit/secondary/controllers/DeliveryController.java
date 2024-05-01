package vn.edu.iuh.fit.secondary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.secondary.enums.DeliveryStatus;
import vn.edu.iuh.fit.secondary.models.Delivery;
import vn.edu.iuh.fit.secondary.services.DeliveryService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/delivery")
@CrossOrigin(origins = "*")
public class DeliveryController {
    private DeliveryService deliveryService;


    @GetMapping("/update-delivery-status")
    public ResponseEntity<String> updateDeliveryStatus(@RequestParam int deviceId, @RequestParam int status){
        DeliveryStatus deliveryStatus = DeliveryStatus.fromValue(status);
        Delivery delivery =  deliveryService.updateDeliveryStatus(deviceId, deliveryStatus).orElse(null);
        if (delivery == null){
            return ResponseEntity.badRequest().body("Delivery not found");
        }
        return ResponseEntity.ok("Update delivery status successfully");
    }
}
