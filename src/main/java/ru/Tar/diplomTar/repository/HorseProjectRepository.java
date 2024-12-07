package ru.Tar.diplomTar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Tar.diplomTar.model.HorseProject;

import java.util.Optional;

@Repository
public interface HorseProjectRepository extends JpaRepository<HorseProject, Long> {
 //   Optional<HorseProject>findById(Long id);
}
