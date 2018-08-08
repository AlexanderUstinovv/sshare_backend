package com.sshare.backend.repository;

import com.sshare.backend.model.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Long> {
    List<Image> findByName(String name);
}
