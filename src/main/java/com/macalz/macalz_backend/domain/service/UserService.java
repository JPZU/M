package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.UserDTO;
import com.macalz.macalz_backend.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        return userRepository.getAll();
    }

    public Optional<UserDTO> findUserById(String userId){
        return userRepository.getById(userId);
    }

    public UserDTO save(UserDTO userDTO){
        return userRepository.save(userDTO);
    }
    public boolean deleteUserById(String userId){
        return findUserById(userId)
                .map(userDTO -> {
                    userRepository.delete(userId);
                    return true;
                }).orElse(false);
    }
}
