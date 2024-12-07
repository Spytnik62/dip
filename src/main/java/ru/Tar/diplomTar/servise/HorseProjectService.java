package ru.Tar.diplomTar.servise;

import org.springframework.stereotype.Service;
import ru.Tar.diplomTar.model.HorseProject;

@Service
public interface HorseProjectService {
    HorseProject saveHorseProject(HorseProject horseProject);
    HorseProject findById(Long id);
}
