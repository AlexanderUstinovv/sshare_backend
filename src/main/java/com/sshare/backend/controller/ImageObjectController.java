package com.sshare.backend.controller;

import com.sshare.backend.model.ImageObject;
import com.sshare.backend.service.ImageObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/imageobject")
public class ImageObjectController {

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Set<ImageObject> getObjectsByImageId(@PathVariable long id) {
        return imageObjectService.getObjectsByImageId(id);
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public void addObjectToImage(@RequestBody Map<String, Object> params) {
        imageObjectService.addObject(params);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteObjectById(@PathVariable long id) {
        imageObjectService.deleteObjectById(id);
    }

    @Autowired
    ImageObjectService imageObjectService;

}
