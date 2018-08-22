package com.sshare.backend.service;

import com.sshare.backend.model.ImageObject;

import java.util.Map;
import java.util.Set;

public interface ImageObjectService {
    void addObject(Map<String, Object> jsonObject);
    Set<ImageObject> getObjectsByImageId(long id);
    void deleteObjectById(long id);
}
