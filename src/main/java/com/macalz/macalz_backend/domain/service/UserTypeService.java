package com.macalz.macalz_backend.domain.service;

import com.macalz.macalz_backend.domain.dto.UserTypeDTO;
import com.macalz.macalz_backend.domain.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserTypeDTO> findAll(){
        return userTypeRepository.getAll();
    }

    public Optional<UserTypeDTO> findUserTypeById(int userTypeId){
        return userTypeRepository.getById(userTypeId);
    }

    public UserTypeDTO save(UserTypeDTO userTypeDTO){
        return userTypeRepository.save(userTypeDTO);
    }

    public boolean deleteUserTypeById(int userTypeId){
        return findUserTypeById(userTypeId)
                .map(userTypeDTO ->{
                    userTypeRepository.delete(userTypeId);
                    return true;
                }).orElse(false);
    }

}
