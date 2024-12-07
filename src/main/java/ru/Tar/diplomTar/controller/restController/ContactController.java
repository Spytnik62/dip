package ru.Tar.diplomTar.controller.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.Tar.diplomTar.model.ContactRequest;

public class ContactController {

    private JavaMailSender emailSender;

    @PostMapping("/contact")
    public ResponseEntity<String> sendContactInfo(@RequestBody ContactRequest contactRequest) {
        try {
            // Создаем сообщение
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("your-email@example.com"); // Замените на ваш email
            message.setSubject("Новый запрос от " + contactRequest.getName());
            message.setText("Телефон: " + contactRequest.getPhone() + "\n" +
                    "Общая площадь: " + contactRequest.getTotalArea() + "\n" +
                    "Тип фундамента: " + contactRequest.getFoundationType() + "\n" +
                    "Материал стен: " + contactRequest.getWallMaterial() + "\n" +
                    "Тип крыши: " + contactRequest.getRoofType());

            emailSender.send(message);
            return ResponseEntity.ok("Запрос отправлен успешно");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка при отправке запроса");
        }
    }
}
