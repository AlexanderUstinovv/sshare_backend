package com.sshare.backend.utils.image;

import java.awt.image.BufferedImage;

public interface ImageSaver {
    String save(BufferedImage bufferedImage, String pathToSave);
}
