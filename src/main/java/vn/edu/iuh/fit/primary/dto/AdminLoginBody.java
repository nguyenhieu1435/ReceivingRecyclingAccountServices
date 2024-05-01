package vn.edu.iuh.fit.primary.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class AdminLoginBody {
    private String username;
    private String password;
}
