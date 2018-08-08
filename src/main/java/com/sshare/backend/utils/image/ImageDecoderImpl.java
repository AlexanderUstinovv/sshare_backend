package com.sshare.backend.utils.image;

import lombok.val;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;

public class ImageDecoderImpl implements ImageDecoder {
    @Override
    public BufferedImage decode(String base64String) {
        BufferedImage image = null;
        byte[] imageByte;

        try {
            val decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(base64String);
            val bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return image;
    }
}
