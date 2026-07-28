package com.ritesh.studyhabitanalyzer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ritesh.studyhabitanalyzer.model.User;
import com.ritesh.studyhabitanalyzer.repository.UserRepository;



@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder encoder;


 // ==============================
 // REGISTER USER
 // ==============================
 public User registerUser(User user) {


     // Check password before encryption
     System.out.println("Before Encryption: "
             + user.getPassword());



     // Encrypt password using BCrypt
     String encryptedPassword = encoder.encode(
             user.getPassword()
     );


     // Set encrypted password
     user.setPassword(encryptedPassword);



     // Check encrypted password
     System.out.println("After Encryption: "
             + user.getPassword());



     // Save user with encrypted password
     return userRepository.save(user);

 }



    // ==============================
    // LOGIN CHECK
    // ==============================
    public boolean checkLogin(String email, String password) {


        // Find user using email
        User user = userRepository.findByEmail(email);



        // If user exists
        if(user != null) {


            // Compare entered password
            // with encrypted password from database
            return encoder.matches(
                    password,
                    user.getPassword()
            );

        }


        // User not found
        return false;

    }




    // ==============================
    // FIND USER BY EMAIL
    // ==============================
    public User findByEmail(String email) {


        return userRepository.findByEmail(email);

    }


}