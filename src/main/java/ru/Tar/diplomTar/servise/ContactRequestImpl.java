//package ru.Tar.diplomTar.servise;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import ru.Tar.diplomTar.model.ContactRequest;
//import ru.Tar.diplomTar.repository.ContactRequestRepository;
//
//import java.util.Optional;
//@Service
//@RequiredArgsConstructor
//public class ContactRequestImpl implements ContactRequestService {
//    private final ContactRequestRepository contactRequestRepository;
//    @Override
//    public ContactRequest save(ContactRequest contactRequest) {
//        ContactRequest newContactRequest = contactRequestRepository.save(contactRequest);
//        return newContactRequest;
//    }
//
//    @Override
//    public ContactRequest findById(Long id) {
//        Optional<ContactRequest> contactRequest = contactRequestRepository.findById(id);
//        ContactRequest contactRequest1 = contactRequest.get();
//        return contactRequest1;
//    }
//}
