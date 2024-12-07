package ru.Tar.diplomTar.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.Tar.diplomTar.model.Role;
import ru.Tar.diplomTar.model.User;
import ru.Tar.diplomTar.repository.RoleRepository;
import ru.Tar.diplomTar.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class UserServisImpl implements UserServis {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final RoleRepository roleRepository;

    @Override
    public User registerUser (User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Проверяем, есть ли роли у пользователя
        List<Role> roles = user.getRoles();
        if (roles == null || roles.isEmpty()) {
            // Используем Optional для поиска роли
            Optional<Role> defaultRoleOptional = roleRepository.findByName("ROLE_USER");

            Role defaultRole;
            if (defaultRoleOptional.isPresent()) {
                defaultRole = defaultRoleOptional.get(); // Получаем роль из Optional
            } else {
                defaultRole = new Role();
                defaultRole.setName("ROLE_USER");
                defaultRole = roleRepository.save(defaultRole); // Сохраняем роль
            }

            roles = List.of(defaultRole); // Создаем список с одной ролью
        } else {
            // Сохраняем каждую роль, если она еще не сохранена
            for (Role role : roles) {
                if (role.getId() == null) { // Если ID роли отсутствует, значит, она еще не сохранена
                    roleRepository.save(role);
                }
            }
        }

        user.setRoles(roles); // Устанавливаем роли пользователю
        User newUser  = userRepository.save(user); // Сохраняем пользователя
        return newUser ;
    }

    @Override
    public boolean exists(String nickname, String email) {
        return userRepository.findByNickname(nickname).isPresent() || userRepository.findByEmail(email).isPresent(); //проверочка
    }
}
