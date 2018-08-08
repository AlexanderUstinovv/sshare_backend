package com.sshare.backend.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "Image")
@Data
public class Image {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_path")
    private String fullPath;

    @NaturalId
    @Column(name = "name")
    private String name;
}
