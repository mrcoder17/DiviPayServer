package ru.nsu.boxberger.DiviPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.boxberger.DiviPay.model.User;
import ru.nsu.boxberger.DiviPay.repository.UserRepository;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    public boolean existUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) != null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userID) {
        return userRepository.findById(userID).orElse(null);
    }

    public User getUserByUsername (String username){
        return userRepository.findByUsername(username);
    }

    public User updateUser(String username, User user) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            if (user.getUsername() != null) {
                existingUser.setUsername(user.getUsername());
            }
            if (user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }
            if (user.getName() != null) {
                existingUser.setName(user.getName());
            }
            if (user.getPhone() != null) {
                existingUser.setPhone(user.getPhone());
            }
            if (user.getAvatar() != null) {
                existingUser.setAvatar(user.getAvatar());
            }

            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
