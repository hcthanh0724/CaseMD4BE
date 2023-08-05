package com.casemodule.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image_post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Image image;
    @ManyToOne
    private Post post;
}
