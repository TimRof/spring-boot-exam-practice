package com.example.practice.service;

import com.example.practice.exception.ConflictException;
import com.example.practice.exception.InternalServerErrorException;
import com.example.practice.exception.ResourceNotFoundException;
import com.example.practice.model.dto.DTOEntity;
import com.example.practice.model.dto.user.UserCreateDTO;
import com.example.practice.model.dto.user.UserGetDTO;
import com.example.practice.model.dto.user.UserUpdateDTO;
import com.example.practice.model.entity.Role;
import com.example.practice.model.entity.User;
import com.example.practice.repository.RoleRepository;
import com.example.practice.repository.UserRepository;
import com.example.practice.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    UserRepository userRepository;
    RoleRepository roleRepository;
    private DtoUtils dtoUtils;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, DtoUtils dtoUtils)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.dtoUtils = dtoUtils;
    }

    public List<DTOEntity> getAll()
    {
        return dtoUtils.convertListToDto(userRepository.findAll(), new UserGetDTO());
    }

    private User getObjectById(long id)
    {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: '" + id + "' not found."));
    }

    public UserGetDTO getById(long id)
    {
        return (UserGetDTO) dtoUtils.convertToDto(getObjectById(id), new UserGetDTO());
    }

    public void updateById(long id, UserUpdateDTO userUpdateDTO)
    {
        User user = getObjectById(id);
        if (userUpdateDTO.getFirstname() != null) user.setFirstname(userUpdateDTO.getFirstname());
        if (userUpdateDTO.getLastname() != null) user.setLastname(userUpdateDTO.getLastname());
        if (userUpdateDTO.getEmail() != null) user.setEmail(userUpdateDTO.getEmail());
        userRepository.save(user);
    }

    public UserGetDTO createOne(UserCreateDTO userCreateDTO)
    {
        if (userRepository.findByEmail(userCreateDTO.getEmail()) != null)
            throw new ConflictException("User with given email already exists");

        User user = (User) new DtoUtils().convertToEntity(new User(), userCreateDTO);
        giveUserRole(user);

        return (UserGetDTO) new DtoUtils().convertToDto(this.userRepository.save(user), new UserGetDTO());
    }

    private User giveUserRole(User user)
    {
        Role userRole = roleRepository.findById(1L).orElseThrow(() -> new InternalServerErrorException("There is a problem with the Role database"));
        user.addRole(userRole);
        return user;
    }

    public void deleteById(long id)
    {
        try
        {
            userRepository.deleteById(id);
        } catch (Exception e)
        {
            throw new ResourceNotFoundException("User with id: '" + id + "' not found.");
        }
    }
}
