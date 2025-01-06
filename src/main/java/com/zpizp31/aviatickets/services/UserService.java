package com.zpizp31.aviatickets.services;

import com.zpizp31.aviatickets.model.User;
import com.zpizp31.aviatickets.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(
            String firstName,
            String middleName,
            String lastName,
            String gender,
            LocalDate dob
    ){
        User user = new User();
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setDateOfBirth(dob);

        userRepository.save(user);
    }

    public User findOrAddUser(String firstName,
                              String middleName,
                              String lastName,
                              String gender,
                              LocalDate dob
    ){
        List<User> users = userRepository.findUser(firstName, middleName, lastName, gender, dob);
        if(users.isEmpty()){
            addUser(firstName, middleName, lastName, gender, dob);
        }

        users = userRepository.findUser(firstName, middleName, lastName, gender, dob);


        return users.get(users.size()-1);
    }

}
