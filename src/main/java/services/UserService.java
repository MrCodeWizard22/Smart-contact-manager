package services;
// import java.lang.classfile.ClassFile;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import entities.User;

@Service
public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String userId);
    Optional<User> getUserByEmail(String email);
    User updateUser(User user);
    void deleteUser(User user);
    boolean isUserExists(String userId);
    boolean isEmailExists(String email);

    List<User> getAllUsers();
}
