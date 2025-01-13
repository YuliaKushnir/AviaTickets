package com.zpizp31.aviatickets.services;

import com.zpizp31.aviatickets.model.User;
import com.zpizp31.aviatickets.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {

    private final UserRepository userRepository;

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

    public LocalDate getDateOfBirth(String year, String month, String day){
        String formattedMonth = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
        System.out.println("Method getDateOfBirth started");
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy MMMM d", Locale.ENGLISH);

        String dateString = year + " " + formattedMonth + " " + day;
        System.out.println("dateString" + dateString);

        LocalDate localDate = LocalDate.parse(dateString, inputFormatter);
        System.out.println("localDate" + localDate);
        return localDate;
    }
}
