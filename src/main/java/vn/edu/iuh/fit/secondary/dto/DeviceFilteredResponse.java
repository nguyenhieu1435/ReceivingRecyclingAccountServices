package vn.edu.iuh.fit.secondary.dto;

import lombok.*;
import vn.edu.iuh.fit.secondary.models.Device;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class DeviceFilteredResponse {
    private int sizeNo;
    private int pageNo;
    private List<Device> devices;
}
