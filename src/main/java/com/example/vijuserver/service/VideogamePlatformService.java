package com.example.vijuserver.service;

import com.example.vijuserver.model.VideogamePlatform;
import com.example.vijuserver.repository.VideogamePlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VideogamePlatformService {
    @Autowired
    private VideogamePlatformRepository videogamePlatformRepository;

    public List<VideogamePlatform> findAll(){
        return videogamePlatformRepository.findAll();
    }
    public Optional<VideogamePlatform> findById(Long id){
        return videogamePlatformRepository.findById(id);
    }
    public VideogamePlatform save(VideogamePlatform vp){
        vp.setCreated_at(LocalDateTime.now());
        return videogamePlatformRepository.save(vp);
    }
    public void deleteById(Long id){
        videogamePlatformRepository.deleteById(id);
    }
}
