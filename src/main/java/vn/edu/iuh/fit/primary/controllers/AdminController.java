package vn.edu.iuh.fit.primary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.primary.dto.AdminLoginBody;
import vn.edu.iuh.fit.primary.models.AdminAccount;
import vn.edu.iuh.fit.primary.services.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<?> handleAdminLogin(@RequestBody AdminLoginBody adminLoginBody){
        AdminAccount adminAccount = adminService.handleLogin(adminLoginBody.getUsername(), adminLoginBody.getPassword()).orElse(null);
        if (adminAccount == null){
            return ResponseEntity.badRequest().body("The username or password is incorrect");
        }
        return ResponseEntity.ok(adminAccount);
    }
}
