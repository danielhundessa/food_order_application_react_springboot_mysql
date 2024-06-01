package com.daniel.food_order.service;

import com.daniel.food_order.Exception.UserException;
import com.daniel.food_order.config.JwtProvider;
import com.daniel.food_order.model.PasswordResetToken;
import com.daniel.food_order.model.User;
import com.daniel.food_order.repository.PasswordResetTokenRepository;
import com.daniel.food_order.repository.UserRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService{

    private UserRepository userRepository;
    private JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder;
    private PasswordResetTokenRepository passwordResetTokenRepository;


    public UserServiceImplementation(
            UserRepository userRepository,
            JwtProvider jwtProvider,
            PasswordEncoder passwordEncoder,
            PasswordResetTokenRepository passwordResetTokenRepository
            ) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.passwordResetTokenRepository = passwordResetTokenRepository;

    }
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getPendingRestaurantOwner() {
        return userRepository.getPendingRestaurantOwners();
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        User user = userRepository.findByEmail(email);

        if(user==null) {
            throw new UserException("User does not exist with email" + email);
        }
        return user;
    }

    @Override
    public User findUserByEmail(String username) throws UserException {
        User user = userRepository.findByEmail(username);

        if(user!=null) {
            return user;
        }
        throw new UserException("User does not exist with username" + username);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void sendPasswordResetEmail(User user) {
        String resetToken = generateRandomToken();
        Date expiryDate = calculateExpiryDate();

        PasswordResetToken passwordResetToken = new PasswordResetToken(resetToken,user,expiryDate);

    }

    private Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 10);
        return cal.getTime();
    }

    private String generateRandomToken() {
        return UUID.randomUUID().toString();
    }
}
