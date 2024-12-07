package ru.Tar.diplomTar.controller.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Tar.diplomTar.model.User;
import ru.Tar.diplomTar.servise.UserServis;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRestController {
    private final UserServis userServis;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userServis.exists(user.getNickname(), user.getEmail())) {
            return ResponseEntity.badRequest().body("Пользователь с таким никнеймом или email уже существует.");
        }
        if (user.getPassword().isEmpty()){
            return ResponseEntity.badRequest().body("Поле с паролем пустое");
        }
        userServis.registerUser (user);
        return ResponseEntity.ok("Регистрация прошла успешно!");
        }



    }


