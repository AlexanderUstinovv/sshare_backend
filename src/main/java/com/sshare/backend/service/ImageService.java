package com.sshare.backend.service;

import com.sshare.backend.model.Image;

public interface ImageService {
    void addImage(String image64);
    void updateImage(Image image);
    void removeImage(long id);
    Image getImageById(long id);
    Image getImageByName(String name);
}
