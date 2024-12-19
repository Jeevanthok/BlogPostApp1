package com.blogpost.blogpost10.serviceimpl;

import com.blogpost.blogpost10.dto.UserDTO;
import com.blogpost.blogpost10.entity.User;
import com.blogpost.blogpost10.exception.ResourceNotFound;
import com.blogpost.blogpost10.repo.UserRepo;
import com.blogpost.blogpost10.services.UserMethod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserMethodImpl implements UserMethod {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToEntity(userDTO);
        User userDto = this.userRepo.save(user);
        return this.EntityToDto(userDto);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, int uuid) {
        User user = this.userRepo.findById(uuid)
                .orElseThrow(() -> new ResourceNotFound("User", "id", uuid));

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        user.setPassword(userDTO.getPassword());
        userRepo.save(user);
        return this.EntityToDto(user);
    }

    @Override
    public UserDTO getUserByid(int uuid) {
        User user = this.userRepo.findById(uuid)
                .orElseThrow(() -> new ResourceNotFound("User", "id", uuid));
        return this.EntityToDto(user);
    }

    @Override
    public List<UserDTO> getAllauseralist() {
        List<User> userLst = this.userRepo.findAll();
        return userLst.stream().map(this::EntityToDto).toList();
    }

    @Override
    public void deleteUser(int uuid) {
        User user = this.userRepo.findById(uuid)
                .orElseThrow(() -> new ResourceNotFound("User", "id", uuid));
        userRepo.delete(user);
    }

    public User dtoToEntity(UserDTO userDTO){
        User user = modelMapper.map(userDTO,User.class);
        return user;
    }

    public UserDTO EntityToDto(User user){
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }
}
