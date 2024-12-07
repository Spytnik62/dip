package ru.Tar.diplomTar.controller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.Tar.diplomTar.model.User;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class LoginPageController {

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody User user) {
    // Проверка на null
    if (user == null || user.getNickname() == null || user.getPassword() == null) {
        return ResponseEntity.badRequest().body("Username or password is missing");
    }

    if (authenticate(user.getNickname(), user.getPassword())) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
    @GetMapping("/loginPage")
    private String getPage()
    {return "loginPage.html";}

    private boolean authenticate(String username, String password) {
        // Здесь должна быть ваша логика проверки учетных данных
        // Например, проверка в базе данных
        return "correctUsername".equals(username) && "correctPassword".equals(password);
    }
}

