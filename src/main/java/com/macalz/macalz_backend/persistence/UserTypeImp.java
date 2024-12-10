package com.macalz.macalz_backend.persistence;

import com.macalz.macalz_backend.domain.dto.UserTypeDTO;
import com.macalz.macalz_backend.domain.repository.UserTypeRepository;
import com.macalz.macalz_backend.persistence.crud.UserTypeCrudRepository;
import com.macalz.macalz_backend.persistence.entity.UserType;
import com.macalz.macalz_backend.persistence.mapper.UserTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserTypeImp implements UserTypeRepository {

    @Autowired
    private UserTypeCrudRepository userTypeCrudRepository;

    @Autowired
    private UserTypeMapper userTypeMapper;

    @Override
    public List<UserTypeDTO> getAll() {
        Iterable<UserType> userTypes = userTypeCrudRepository.findAll();
        return StreamSupport.stream(userTypes.spliterator(), false)
                .map(userTypeMapper::toUserTypeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserTypeDTO> getById(int userTypeId) {
        return userTypeCrudRepository.findById(userTypeId)
                .map(userTypeMapper::toUserTypeDTO);
    }

    @Override
    public UserTypeDTO save(UserTypeDTO userTypeDTO) {
        UserType userTypeEntity = userTypeMapper.toUserType(userTypeDTO);
        UserType savedUserType = userTypeCrudRepository.save(userTypeEntity);

        return userTypeMapper.toUserTypeDTO(savedUserType);
    }

    @Override
    public void delete(int userTypeId) {
        userTypeCrudRepository.deleteById(userTypeId);
    }
}
