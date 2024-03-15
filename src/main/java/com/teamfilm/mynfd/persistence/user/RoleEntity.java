package com.teamfilm.mynfd.persistence.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    private int id;

    private String name;

}
