package ru.Tar.diplomTar.servise;

import org.springframework.stereotype.Service;
import ru.Tar.diplomTar.model.ContactRequest;

@Service
public interface ContactRequestService {
    ContactRequest save(ContactRequest contactRequest);
    ContactRequest findById(Long id);
}
