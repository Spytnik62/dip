package ru.Tar.diplomTar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Tar.diplomTar.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional <User> findByNickname(String name);
    Optional <User> findByEmail(String email);
}
