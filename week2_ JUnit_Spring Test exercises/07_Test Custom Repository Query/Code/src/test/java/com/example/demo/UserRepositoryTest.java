package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user1 = new User(1L, "Sabarna");
        User user2 = new User(2L, "Sabarna");
        User user3 = new User(3L, "Arun");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> sabarnaUsers = userRepository.findByName("Sabarna");

        assertEquals(2, sabarnaUsers.size());
        for (User user : sabarnaUsers) {
            assertEquals("Sabarna", user.getName());
        }
    }
}
