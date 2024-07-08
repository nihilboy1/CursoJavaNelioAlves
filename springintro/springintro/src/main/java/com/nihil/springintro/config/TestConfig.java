package com.nihil.springintro.config;

import com.nihil.springintro.entities.User;
import com.nihil.springintro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    // esse autowired permite que eu use a classe UserRepository sem ter que passar ela como argumento no construtor
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
