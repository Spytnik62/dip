package ru.Tar.diplomTar.servise;

import org.springframework.stereotype.Service;
import ru.Tar.diplomTar.model.User;


@Service
public interface UserServis  {
    User registerUser(User user);
    boolean exists(String nickname, String email);
}
