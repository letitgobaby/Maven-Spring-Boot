package com.example.core.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 50)
    String title;

    @Column(length = 50)
    String subtitle;

    @Column(length = 50)
    String href;

    @UpdateTimestamp
    LocalDateTime updated;

    @Column(columnDefinition = "TEXT")
    String content;

    String banner;

}