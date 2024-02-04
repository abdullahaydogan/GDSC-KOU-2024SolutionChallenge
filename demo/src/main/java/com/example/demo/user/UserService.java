package com.example.demo.user;

import com.example.demo.configuration.CurrentUser;
import com.example.demo.user.dto.UserUpdate;
import com.example.demo.user.exception.InvalidTokenException;
import com.example.demo.user.exception.NotUniqueEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = MailException.class)
    void userSave(User user) {
        try {
            user.setActivationToken(UUID.randomUUID().toString());
            userRepository.saveAndFlush(user);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new NotUniqueEmailException();
        }
    }

    public Page<User> getUsers(Pageable pageable, CurrentUser currentUser) {
        if (currentUser == null) {
            return userRepository.findAll(pageable);
        } else {
            return userRepository.findByIdNot(currentUser.getId(), pageable);
        }
    }

    public User getUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User updateUser(int id, UserUpdate userUpdate) {
        User inDB = getUserById(id);
        inDB.setUsername(userUpdate.username());
        inDB.setPassword(userUpdate.password());
        inDB.setEmail(userUpdate.email());
        inDB.setCity(userUpdate.city());
        inDB.setPhoneNumber(userUpdate.phoneNumber());
        inDB.setLongitude(userUpdate.longitude());
        inDB.setLatitude(userUpdate.latitude());
        return userRepository.save(inDB);
    }

    public void activateUser(String token) {
        User inDB = userRepository.findByActivationToken(token);
        if (inDB == null) {
            throw new InvalidTokenException();
        }
        inDB.setActive(true);
        inDB.setActivationToken(null);
        userRepository.save(inDB);
    }
}
