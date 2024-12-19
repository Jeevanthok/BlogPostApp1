package com.blogpost.blogpost10.services;

import com.blogpost.blogpost10.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserMethod {

    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO, int uuid);
    UserDTO getUserByid(int uuid);
    List<UserDTO> getAllauseralist();
    void deleteUser(int uuid);
}
