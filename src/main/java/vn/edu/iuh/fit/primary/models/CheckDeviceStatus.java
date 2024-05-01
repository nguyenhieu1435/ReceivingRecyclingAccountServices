package vn.edu.iuh.fit.primary.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.primary.enums.CheckDeviceResponseStatus;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class CheckDeviceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long deviceId;
    @Column(name = "name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;
    @Column(name = "model", columnDefinition = "VARCHAR(100)", nullable = false)
    private String model;
    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;
    @Column(name = "price_suggested", nullable = false)
    private double priceSuggested;
    @Column(name = "real_price", nullable = false)
    private double realPrice;
    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String CheckInfoDescription;
    @Column(name = "status", nullable = false)
    private CheckDeviceResponseStatus status;
    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "username", nullable = false)
    private AdminAccount createdBy;

}
