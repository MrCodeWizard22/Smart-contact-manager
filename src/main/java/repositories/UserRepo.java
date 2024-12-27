package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // Your repository methods here
}