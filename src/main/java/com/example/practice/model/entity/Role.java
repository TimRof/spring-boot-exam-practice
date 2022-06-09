package com.example.practice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"role\"")
public class Role
{
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE}, mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

    public Role(long id, String name)
    {
        this.id = id;
        this.name = name;
    }
}
