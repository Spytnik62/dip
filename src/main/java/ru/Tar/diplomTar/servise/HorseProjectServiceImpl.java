package ru.Tar.diplomTar.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Tar.diplomTar.model.HorseProject;
import ru.Tar.diplomTar.repository.HorseProjectRepository;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class HorseProjectServiceImpl implements HorseProjectService{
    private final HorseProjectRepository horseProjectRepository;
    @Override
    public HorseProject saveHorseProject(HorseProject horseProject) {
        HorseProject newHosreProject = horseProjectRepository.save(horseProject);
        return newHosreProject;
    }

    @Override
    public HorseProject findById(Long id) {
        Optional<HorseProject>horseProject = horseProjectRepository.findById(id);
        HorseProject horseProject1 = horseProject.get();
        return horseProject1;
    }
}
