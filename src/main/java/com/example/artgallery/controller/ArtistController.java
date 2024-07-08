package com.example.artgallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.artgallery.model.*;
import com.example.artgallery.service.*;

@RestController
public class ArtistController {
    @Autowired
    private ArtistJpaService AJS;

    @GetMapping("/galleries/artists")
    public ArrayList<Artist> getAllArtist() {
        return AJS.getAllArtist();
    }

    @GetMapping("/galleries/artists/{artistId}")
    public Artist getArtistById(@PathVariable("artistId") int artistId) {
        return AJS.getArtistById(artistId);
    }

    @PostMapping("/galleries/artists")
    public Artist addArtistById(@RequestBody Artist artist) {
        return AJS.addArtistById(artist);
    }

    @PutMapping("/galleries/artists/{artistId}")
    public Artist updateArtist(@PathVariable("artistId") int artistId, @RequestBody Artist artist) {
        return AJS.updateArtist(artistId, artist);
    }

    @DeleteMapping("/galleries/artists/{artistId}")
    public void deleteArtist(@PathVariable("artistId") int artistId) {
        AJS.deleteArtist(artistId);
    }

    @GetMapping("/artists/{artistId}/arts")
    public List<Art> getArtistArts(@PathVariable("artistId") int artistId){
        return AJS.getArtistArts(artistId);
    }

    @GetMapping("/artists/{artistId}/galleries")
    public List<Gallery> getArtistGalleries(@PathVariable("artistId") int artistId){
        return AJS.getArtistGalleries(artistId);
    }
}