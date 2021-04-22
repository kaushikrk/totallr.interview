package com.totallr.demo.service;

import com.totallr.demo.model.Response;
import com.totallr.demo.model.User;
import com.totallr.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    Response response = new Response();

    public boolean validate(User user) {

        if (user.getName().equals("")) {
            response.setMessage("Name field cannot be empty");
        } else if (user.getAge() == null) {
            response.setMessage("Age field cannot be empty");
        } else if(user.getAge() < 0) {
            response.setMessage("Invalid age");
        } else if (user.getAddress().equals("")) {
            response.setMessage("Address field cannot be empty");
        } else if (user.getProfession().equals("")||!user.professions.contains(user.getProfession())) {
            response.setMessage("Profession field cannot be empty");
        } else {
            response.setMessage("Success");
            response.setStatus(200);
        }

        if (response.getMessage().equals("Success")) {
            return true;
        } else{
            response.setStatus(400);
            return false;
        }
    }

    public Response createUser(User user) {

        boolean success = validate(user);

        if (success) {
            repo.save(user);
            response.setMessage("User successfully created");
        }
        return response;
    }

    public Iterable<User> viewUsers() {
        return repo.findAll();
    }
}
