package ru.kata.preproject.SpringSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.preproject.SpringSecurityApp.entity.User;
import ru.kata.preproject.SpringSecurityApp.repository.UsersRepository;
import ru.kata.preproject.SpringSecurityApp.security.UsersDetails;

import java.util.Optional;

@Service
public class UsersDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findByUsername(s);

        if(user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UsersDetails(user.get());
    }
}
