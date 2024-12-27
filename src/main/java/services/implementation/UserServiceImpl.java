package services.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import entities.User;
import repositories.UserRepo;
import services.UserService;

@Service
public class UserServiceImpl implements UserService {
    // @Autowired
    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserRepo userRepo;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return userRepo.findById(userId);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findById(email);
    }

    @Override
    public User updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        user2.setUsername(user.getUsername());
        user2.setEmail(user.getEmail());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setPassword(user.getPassword());
        user2.setProfilePic(user.getProfilePic());

        return null;
    }

    @Override
    public void deleteUser(User user) {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExists(String userId) {
        return userRepo.existsById(userId);
    }

    @Override
    public boolean isEmailExists(String email) {
        User user = userRepo.findById(email).orElse(null);
        return user != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

}
