package com.daniel.food_order.service;

import com.daniel.food_order.Exception.UserException;
import com.daniel.food_order.model.User;
import java.util.List;

public interface UserService {
    public List<User> findAllUsers();
    public List<User> getPendingRestaurantOwner();

    public User findUserProfileByJwt(String jwt) throws UserException;
    public User findUserByEmail(String email) throws UserException;

    void updatePassword(User user, String newPassword);
    void sendPasswordResetEmail(User user);
}
