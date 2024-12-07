package ru.Tar.diplomTar.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.Tar.diplomTar.model.Role;
import ru.Tar.diplomTar.repository.RoleRepository;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByName(String name) {
        Optional<Role> roleOptional = roleRepository.findByName(name);
        return roleOptional.orElse(null); // Возвращает роль или null, если не найдена
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}