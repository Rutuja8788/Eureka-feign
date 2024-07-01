package com.userserviceproject.userserviceproject.service;






import com.userserviceproject.userserviceproject.Entity.User;
import com.userserviceproject.userserviceproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user)

    {
        return userRepository.save(user);
    }
}
