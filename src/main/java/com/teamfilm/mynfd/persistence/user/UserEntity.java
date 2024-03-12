package com.teamfilm.mynfd.persistence.user;

import com.teamfilm.mynfd.persistence.review.ReviewEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // password null validation is done by BCryptEncoder
    @Column(name = "password")
    private String password;

    @OneToMany
    private Set<ReviewEntity> reviews;

}
