package com.sshare.backend.utils.image;

import lombok.val;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

public class ImageSaverImpl implements ImageSaver {

    @Override
    public String save(BufferedImage bufferedImage, String pathToSave) {
        File file = null;

        try {
            val uniqueFileName = UUID.randomUUID().toString() + ".png";
            file = new File(Paths.get(pathToSave, uniqueFileName).toString());
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return file.getAbsolutePath();
    }
}
