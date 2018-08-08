package com.sshare.backend.utils.image;


import java.awt.image.BufferedImage;

public interface ImageDecoder {
    BufferedImage decode(String base64String);
}
