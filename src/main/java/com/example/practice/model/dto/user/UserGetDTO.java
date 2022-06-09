package com.example.practice.model.dto.user;

import com.example.practice.model.dto.DTOEntity;
import com.example.practice.model.entity.Role;

import java.util.List;

public class UserGetDTO implements DTOEntity
{
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private List<Role> roles;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    public UserGetDTO(long id, String firstname, String lastname, String email)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public UserGetDTO()
    {
    }
}
