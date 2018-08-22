package com.sshare.backend.service;

import com.sshare.backend.model.ImageObject;
import com.sshare.backend.model.ObjectName;
import com.sshare.backend.repository.ImageObjectRepository;
import com.sshare.backend.repository.ImageRepository;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class ImageObjectServiceImpl implements ImageObjectService {
    @Override
    public void addObject(Map<String, Object> jsonObject) {
        try {
            val imageObject = new ImageObject();
            imageObject.setColor(jsonObject.get("color").toString());
            imageObject.setObjectName(ObjectName.valueOf(jsonObject.get("object_name").toString()));
            imageObject.setPoints(jsonObject.get("points").toString());
            imageObjectRepository.save(imageObject);

            val imageOptional = imageRepository.findById(Long.valueOf(jsonObject.get("image_id").toString()));
            imageOptional.ifPresent(image -> {
                val objects = image.getImageObjects();
                objects.add(imageObject);
                image.setImageObjects(objects);
                imageRepository.save(image);
            });
        } catch (Exception ex) {
            logger.error("Bad parameters, imageObject not saved");
        }
    }

    @Override
    public Set<ImageObject> getObjectsByImageId(long id) {
        val image = imageRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Image by id not found"));
        return image.getImageObjects();
    }

    @Override
    public void deleteObjectById(long id) {
        imageObjectRepository.deleteById(id);
    }

    @Autowired
    ImageObjectRepository imageObjectRepository;

    @Autowired
    ImageRepository imageRepository;

    private static final Logger logger = LoggerFactory.getLogger(ImageObjectServiceImpl.class);
}
