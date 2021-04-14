package com.paargav.spring_boot_task.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get Users
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // Create User
    public void createUser(User user) throws Exception {

//        Validation ???
        if (user.getName() == null || user.getName().length() == 0) {
            throw new Exception("Invalid Name");
        }

        if (user.getAge() <= 0) {
            throw new Exception("Invalid Age");
        }

        if (user.getAddress() == null || user.getAddress().length() == 0) {
            throw new Exception("Invalid Address");
        }

        if (user.getProfession() == null || user.getProfession().length() == 0 || !user.professionValues.contains(user.getProfession())) {
            throw new Exception("Invalid Profession");
        }

        userRepository.save(user);

    }
}
