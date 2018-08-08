package com.sshare.backend.controller;

import com.sshare.backend.model.Image;
import com.sshare.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Image getImage(@PathVariable int id) {
        return imageService.getImageById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addImage(@RequestBody Map<String, String> params) {
        imageService.addImage(params.get("image64"));
    }

    @DeleteMapping(value = "remove/{id}")
    @ResponseBody
    public void removeImage(@PathVariable("id") int id) {
        imageService.removeImage(id);
    }

    @Autowired
    private ImageService imageService;
}
