package vn.edu.iuh.fit.secondary.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.secondary.enums.DeliveryStatus;
import vn.edu.iuh.fit.secondary.models.Delivery;
import vn.edu.iuh.fit.secondary.repositories.DeliveryRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Optional<Delivery> getDeliveryByDeliveryIdAndPhoneNumber(long deliveryId, String phoneNumber) {
        return deliveryRepository.getDeliveryByDeliveryIdAndPhoneNumber(deliveryId, phoneNumber);
    }

    public Optional<Delivery> updateDeliveryStatus(int deviceId, DeliveryStatus deliveryStatus){
        Delivery delivery = deliveryRepository.findDeliveryByDevice_DeviceId(deviceId).orElse(null);
        if (delivery == null){
            return Optional.empty();
        }
        delivery.setStatus(deliveryStatus);
        delivery = deliveryRepository.save(delivery);
        return Optional.of(delivery);
    }
}
