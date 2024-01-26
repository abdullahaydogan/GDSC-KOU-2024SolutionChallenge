package com.example.demo.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.validation.NotUniqueEmailException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = MailException.class)
    void userSave(User user) {
        try {
            user.setActivationToken(UUID.randomUUID().toString());
            userRepository.saveAndFlush(user);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new NotUniqueEmailException();
        }
    }

}
