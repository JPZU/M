package com.macalz.macalz_backend.persistence;

import com.macalz.macalz_backend.domain.dto.UserDTO;
import com.macalz.macalz_backend.domain.repository.UserRepository;
import com.macalz.macalz_backend.persistence.crud.UserCrudRepository;
import com.macalz.macalz_backend.persistence.entity.User;
import com.macalz.macalz_backend.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepositoryImp implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAll(){
        Iterable<User> users = userCrudRepository.findAll();

        return StreamSupport.stream(users.spliterator(), false)
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getById(String userId){
        return userCrudRepository.findById(userId)
                .map(userMapper::toUserDTO);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User userEntity = userMapper.toUser(userDTO);
        User savedUser = userCrudRepository.save(userEntity);

        return userMapper.toUserDTO(savedUser);
    }

    @Override
    public void delete (String userId){
        userCrudRepository.deleteById(userId);
    }
}
