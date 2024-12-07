package ru.Tar.diplomTar.util;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.Tar.diplomTar.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        var user = userRepository.findByNickname(nickname).get();

        User userDetails = new User(
                user.getNickname(),
                user.getPassword(),
                user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList());
        return userDetails;
//        User user = userRepository.findByNickname(nickname)
//                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getNickname())
//                .password(user.getPassword())
//                .roles("USER") // Укажите роли пользователя
//                .build();
    }
}