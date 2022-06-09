package com.example.practice.model.dto.user;

import com.example.practice.model.dto.DTOEntity;

public class UserUpdateDTO implements DTOEntity
{
    private String firstname;
    private String lastname;
    private String email;

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
}
