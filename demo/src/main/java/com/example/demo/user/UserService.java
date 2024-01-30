package com.example.demo.user;

import com.example.demo.user.dto.UserUpdate;
import com.example.demo.user.exception.NotUniqueEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    public User updateUser(int id, UserUpdate userUpdate) {
        User inDB = getUserById(id);
        inDB.setPassword(userUpdate.password());
        inDB.setEmail(userUpdate.email());
        inDB.setCity(userUpdate.city());
        inDB.setPhoneNumber(userUpdate.phoneNumber());
        inDB.setLongitude(userUpdate.longitude());
        inDB.setLatitude(userUpdate.latitude());
        return userRepository.save(inDB);
    }
}
