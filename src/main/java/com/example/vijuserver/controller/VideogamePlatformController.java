package com.example.vijuserver.controller;

import com.example.vijuserver.error.VideogamePlatformNotFoundException;
import com.example.vijuserver.model.VideogamePlatform;
import com.example.vijuserver.service.VideogamePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class VideogamePlatformController {
    private final VideogamePlatformService videogamePlatformService;

    @GetMapping("/videogame_platforms")
    public ResponseEntity<List<VideogamePlatform>> findAll(){
        List<VideogamePlatform> videogamePlatforms = videogamePlatformService.findAll();
        if(videogamePlatforms.isEmpty()){
            throw new VideogamePlatformNotFoundException();
        }
        return ResponseEntity.ok(videogamePlatforms);
    }
    @GetMapping("/videogame_platform/{id}")
    public ResponseEntity<VideogamePlatform> findById(@PathVariable Long id) {
        VideogamePlatform videogamePlatform = videogamePlatformService.findById(id).orElseThrow(() -> new VideogamePlatformNotFoundException(id));
        return ResponseEntity.ok(videogamePlatform);
    }
    @PostMapping("/videogame_platform")
    public ResponseEntity<VideogamePlatform> save(@RequestBody VideogamePlatform videogamePlatform) {
        videogamePlatform.setId(null);
        videogamePlatform = videogamePlatformService.save(videogamePlatform);
        return ResponseEntity.status(HttpStatus.CREATED).body(videogamePlatform);
    }
    @PutMapping("/videogame_platform/{id}")
    public ResponseEntity<VideogamePlatform> update(@PathVariable Long id, @RequestBody VideogamePlatform videogamePlatform) {
        Optional<VideogamePlatform> videogamePlatform1 = videogamePlatformService.findById(id);
        if (videogamePlatform1.isPresent()) {
            videogamePlatform.setId(id);
            VideogamePlatform videogamePlatformUpdated = videogamePlatformService.save(videogamePlatform);
            return new ResponseEntity<>(videogamePlatformUpdated, HttpStatus.OK);
        } else {
            throw new VideogamePlatformNotFoundException(id);
        }
    }
    @DeleteMapping("/videogame_platform/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<VideogamePlatform> videogamePlatform = videogamePlatformService.findById(id);
        if (videogamePlatform.isPresent()) {
            videogamePlatformService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new VideogamePlatformNotFoundException(id);
        }
    }
}
