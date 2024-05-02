package vn.edu.iuh.fit.primary.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.primary.enums.AdminAccountStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "admin_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class AdminAccount {
    @Id
    @Column(name = "username", columnDefinition = "VARCHAR(50)")
    private String username;
    @Column(name = "password", columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;
    @Column(name = "full_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;
    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
    private String gender;
    @Column(name = "dob", nullable = false)
    private LocalDateTime dob;
    private LocalDateTime createAt;
    @Column(name = "status", nullable = false)
    private AdminAccountStatus status;
    @JsonIgnore
    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CheckDeviceStatus> checkDeviceStatuses;

    public AdminAccount(String username) {
        this.username = username;
    }
}
