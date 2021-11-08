package org.leti.Service;

import org.leti.Domain.Role;
import org.leti.Domain.User;
import org.leti.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    MailSender mailSender;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws LockedException {
        User userFromDb = userRepo.findByUsername(username);
        if (userFromDb == null)
            throw new LockedException("Неверные логин/пароль");
        return userFromDb;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);

        sendMessageAboutActivate(user);

        return true;
    }

    private void sendMessageAboutActivate(User user) {
        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Добро пожаловать на веб-сервис, %s! \n" +
                            "Пожалуйста, подтвердите учетную запись, перейдя по ссылке: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Код активации", message);
        }
    }


    public boolean activateUser( String code) {
        User user = userRepo.findByActivationCode(code);

        if (user == null)
            return false;
        user.setActivationCode(null);
        user.setActive(true);

        userRepo.save(user);

        return true;
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public boolean saveUser(User user, String username, Map<String, String> form) {
        user.setUsername(username);
        user.getRoles().clear();

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key))
                user.getRoles().add(Role.valueOf(key));
        }
        userRepo.save(user);

        return true;
    }

    public void updateProfile(User user, String password, String email) {
        String userEmail = user.getEmail();

        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                                 (userEmail != null && !userEmail.equals(email));

        if (isEmailChanged) {
            user.setEmail(email);
            user.setActivationCode(UUID.randomUUID().toString());
        }
        if (!StringUtils.isEmpty(password))
            user.setPassword(passwordEncoder.encode(password));

        userRepo.save(user);

        if (isEmailChanged)
        sendMessageAboutActivate(user);

    }
}
