package com.teamfilm.nfd.persistence.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    private int id;

    private String name;

}
