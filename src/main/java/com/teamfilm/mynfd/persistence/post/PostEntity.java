package com.teamfilm.mynfd.persistence.post;

import com.teamfilm.mynfd.persistence.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    @ManyToOne
    private CategoryEntity category;

}
