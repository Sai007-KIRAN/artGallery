package com.example.artgallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.artgallery.model.*;
import com.example.artgallery.service.*;

@RestController

public class GalleryController {
    @Autowired
    private GalleryJpaService GJS;

    @GetMapping("/galleries")
    public ArrayList<Gallery> getAllGallery() {
        return GJS.getAllGallery();
    }

    @GetMapping("/galleries/{galleryId}")
    public Gallery getGalleryById(@PathVariable("galleryId") int galleryId) {
        return GJS.getGalleryById(galleryId);
    }

    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery gallery) {
        return GJS.addGallery(gallery);
    }

    @PutMapping("/galleries/{galleryId}")
    public Gallery updateGallery(@PathVariable("galleryId") int galleryId, @RequestBody Gallery gallery) {
        return GJS.updateGallery(galleryId, gallery);
    }

    @DeleteMapping("/galleries/{galleryId}")
    public void deleteGallery(@PathVariable("galleryId") int galleryId) {
        GJS.deleteGallery(galleryId);
    }

    @GetMapping("/galleries/{galleryId}/artists")
    public List<Artist> getArtistGallery(@PathVariable("galleryId") int galleryId) {
        return GJS.getArtistGallery(galleryId);
    }
}