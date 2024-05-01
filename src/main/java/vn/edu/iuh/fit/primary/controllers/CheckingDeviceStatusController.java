package vn.edu.iuh.fit.primary.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.primary.dto.AddCheckingDeviceStatusBody;
import vn.edu.iuh.fit.primary.enums.CheckDeviceResponseStatus;
import vn.edu.iuh.fit.primary.models.AdminAccount;
import vn.edu.iuh.fit.primary.models.CheckDeviceStatus;
import vn.edu.iuh.fit.primary.services.CheckDeviceStatusService;

@RestController
@RequestMapping("/api/checking-device-status")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CheckingDeviceStatusController {
    private CheckDeviceStatusService checkDeviceStatusService;
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println(to);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    @PostMapping("/addAndSendEmail")
    public ResponseEntity<String> handleAddAndSendEmail(@RequestBody AddCheckingDeviceStatusBody addCheckingDeviceStatusBody) {
        CheckDeviceStatus checkDeviceStatus = new CheckDeviceStatus();
        checkDeviceStatus.setDeviceId(addCheckingDeviceStatusBody.getDeviceId());
        checkDeviceStatus.setName(addCheckingDeviceStatusBody.getName());
        checkDeviceStatus.setModel(addCheckingDeviceStatusBody.getModel());
        checkDeviceStatus.setEmail(addCheckingDeviceStatusBody.getEmail());
        checkDeviceStatus.setStatus(CheckDeviceResponseStatus.WAITING);
        checkDeviceStatus.setCheckInfoDescription(addCheckingDeviceStatusBody.getMessage());
        checkDeviceStatus.setCreatedBy(new AdminAccount(addCheckingDeviceStatusBody.getCreatedBy()));
        checkDeviceStatus.setPriceSuggested(addCheckingDeviceStatusBody.getPriceSuggested());
        checkDeviceStatus.setRealPrice(addCheckingDeviceStatusBody.getRealPrice());

        System.out.println(addCheckingDeviceStatusBody);

        try {
            checkDeviceStatus = checkDeviceStatusService.addCheckDeviceStatus(checkDeviceStatus);
            sendEmail(checkDeviceStatus.getEmail(), "Báo giá sau khi kiểm tra máy: "
                            + checkDeviceStatus.getName() + " có deviceId: " + checkDeviceStatus.getDeviceId()
                    , "Gía được báo trước khi bạn gửi đi là: " + checkDeviceStatus.getPriceSuggested()
                            + " và giá thực tế sau khi kiểm tra là: " + checkDeviceStatus.getRealPrice()
                            + " và tình trạng của máy sau khi kiểm tra là: "
                            + checkDeviceStatus.getCheckInfoDescription() + " bạn cần đồng ý hoặc từ chối báo giá" +
                            " này để chúng tôi có thể thực hiện bước tiếp theo");

            return ResponseEntity.ok("Add and send email successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Add and send email failed");
        }

    }


}
