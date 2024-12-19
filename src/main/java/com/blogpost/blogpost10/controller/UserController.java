package com.blogpost.blogpost10.controller;

import com.blogpost.blogpost10.dto.UserDTO;
import com.blogpost.blogpost10.entity.User;
import com.blogpost.blogpost10.serviceimpl.UserMethodImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMethodImpl userMethodimpl;

    //get user data
    @GetMapping("/getoneuser/{userid}")
    public ResponseEntity<UserDTO> getOneUserInfo(@PathVariable("userid") int userid){
        UserDTO getOneuserDTO = userMethodimpl.getUserByid(userid);
        return new ResponseEntity<>(getOneuserDTO,HttpStatus.ACCEPTED);
    }

    //get All user
    @GetMapping("/getAlluser")
    public ResponseEntity<List<UserDTO>> getAllUserInfo(){
        List<UserDTO> getOneuserDTO = userMethodimpl.getAllauseralist();
        return  ResponseEntity.ok(getOneuserDTO);
    }

    //update user data
    @PutMapping("/updateuser/{userid}")
    public ResponseEntity<UserDTO> updateuser(@RequestBody UserDTO userDTO, @PathVariable("userid") int useruuid){
        UserDTO updateUser = userMethodimpl.updateUser(userDTO,useruuid);
        return new ResponseEntity<>(updateUser, HttpStatus.ACCEPTED);
    }

    //post user data
    @PostMapping("crateuser")
    public ResponseEntity<UserDTO> createuser(@RequestBody() UserDTO user){
      UserDTO createuserDTO = userMethodimpl.createUser(user);
      return new ResponseEntity<>(createuserDTO, HttpStatus.CREATED);
    }
    //delete user data

    @DeleteMapping("deleteuser/{userid}")
    public ResponseEntity<?> deleteuser(@PathVariable("userid") int useruuid){
        userMethodimpl.deleteUser(useruuid);
        return ResponseEntity.ok(Map.of("message","user deleted successfully"));
    }

}
