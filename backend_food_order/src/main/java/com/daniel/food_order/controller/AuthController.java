package com.daniel.food_order.controller;

import com.daniel.food_order.Exception.UserException;
import com.daniel.food_order.config.JwtProvider;
import com.daniel.food_order.domain.USER_ROLE;
import com.daniel.food_order.model.Cart;
import com.daniel.food_order.model.User;
import com.daniel.food_order.repository.UserRepository;
import com.daniel.food_order.response.AuthResponse;
import com.daniel.food_order.service.CustomUserServiceImplementation;
import com.daniel.food_order.service.PasswordResetTokenService;
import com.daniel.food_order.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtProvider jwtProvider;
    private CustomUserServiceImplementation customUserDetails;
    private PasswordResetTokenService passwordResetTokenService;
    private UserService userService;

    public AuthController(
            UserRepository userRepository ,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider,
            CustomUserServiceImplementation customUserDetails,
            PasswordResetTokenService passwordResetTokenService,
            UserService userService

    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.customUserDetails = customUserDetails;
        this.passwordResetTokenService = passwordResetTokenService;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler (@Valid @RequestBody User user) throws UserException {
        String email = user.getEmail();
        String password = user.getPassword();
        String fullName = user.getFullName();
        USER_ROLE role = user.getRole();

        User isEmailExist = userRepository.findByEmail(email);

        if (isEmailExist!=null) {
            throw new UserException("Email is already used");
        }

        User createdUser = new User();
        createdUser.setEmail(email);
        createdUser.setFullName(fullName);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setRole(role);

        User savedUser = userRepository.save(createdUser);

        Cart cart = new Cart();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.toString()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(email, password, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("Register success");
        authResponse.setRole(savedUser.getRole());

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
}
