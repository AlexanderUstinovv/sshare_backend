package com.sshare.backend.service;

import com.sshare.backend.config.SshareProperties;
import com.sshare.backend.model.Image;
import com.sshare.backend.repository.ImageRepository;
import com.sshare.backend.utils.image.ImageDecoderImpl;
import com.sshare.backend.utils.image.ImageSaverImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public void addImage(String image64) {
        imageRepository.save(createImage(image64));
    }

    @Override
    public void updateImage(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void removeImage(long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image getImageById(long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image getImageByName(String name) {
        return imageRepository.findByName(name).get(0);
    }

    private Image createImage(String image64) {
        val filePath = decodeAndSaveImage(image64);
        val image = new Image();
        val imageName = Paths.get(filePath).getFileName().toString();
        image.setName(imageName.substring(0, imageName.lastIndexOf(".")));
        image.setFullPath(filePath);
        return image;
    }

    private String decodeAndSaveImage(String image64) throws IllegalArgumentException {
        if (image64 != null) {
            val decoder = new ImageDecoderImpl();
            val saver = new ImageSaverImpl();
            val image = decoder.decode(image64);
            if (image != null) {
                val filePath = saver.save(decoder.decode(image64), sshareProperties.getFileStore().getPath());
                return Paths.get(filePath).getFileName().toString();
            } else {
                throw new IllegalArgumentException("Bad image64 string");
            }
        } else {
            throw new IllegalArgumentException("The 'image64' parameter must not be null or empty");
        }
    }

    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private SshareProperties sshareProperties;
}
