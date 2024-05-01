package vn.edu.iuh.fit.primary.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class AddCheckingDeviceStatusBody {
    private Long deviceId;
    private String name;
    private String model;
    private String email;
    private double priceSuggested;
    private double realPrice;
    private String message;
    private String createdBy;

}
