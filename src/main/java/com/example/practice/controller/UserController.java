package com.example.practice.controller;

import com.example.practice.model.dto.DTOEntity;
import com.example.practice.model.dto.user.UserCreateDTO;
import com.example.practice.model.dto.user.UserUpdateDTO;
import com.example.practice.service.UserService;
import com.example.practice.model.dto.user.UserGetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/users")
public class UserController
{
    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<DTOEntity>> getAll()
    {
        return new ResponseEntity<List<DTOEntity>>(this.userService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<UserGetDTO> getById(@PathVariable long id)
    {
        return new ResponseEntity<UserGetDTO>(this.userService.getById(id), HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Void> getById(@PathVariable long id, @RequestBody UserUpdateDTO userUpdateDTO)
    {
        this.userService.updateById(id, userUpdateDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<UserGetDTO> createOne(@RequestBody UserCreateDTO userCreateDTO)
    {
        return new ResponseEntity<UserGetDTO>(this.userService.createOne(userCreateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Void> deleteById(@PathVariable long id)
    {
        this.userService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
