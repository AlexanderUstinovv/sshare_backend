package com.sshare.backend.repository;

import com.sshare.backend.model.ImageObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageObjectRepository extends JpaRepository<ImageObject, Long> {
    Optional<ImageObject> findById(Long id);
    List<ImageObject> findAllById(Iterable<Long> iterable);
}