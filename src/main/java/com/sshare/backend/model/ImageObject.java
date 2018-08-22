package com.sshare.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "imageobject")
@Data
public class ImageObject {

    public ImageObject(String color, String points, ObjectName objectName) {
        this.color = color;
        this.points = points;
        this.objectName = objectName;
    }

    public ImageObject() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "color")
    private String color;

    @Column(name = "points")
    private String points;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private ObjectName objectName;

}
