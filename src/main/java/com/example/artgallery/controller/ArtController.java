package com.example.artgallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.artgallery.model.*;
import com.example.artgallery.service.*;

@RestController
public class ArtController{
    @Autowired 
    private ArtJpaService AJS;

    @GetMapping("/galleries/artists/arts")
    public ArrayList<Art> getAllArt(){
        return AJS.getAllArt();
    }

    @GetMapping("/galleries/artists/arts/{artId}")
    public Art ArtById(@PathVariable("artId") int artId){
        return AJS.ArtById(artId);
    }

    @PostMapping("/galleries/artists/arts")
    public Art getAddArt(@RequestBody Art art){
        return AJS.getAddArt(art);
    }

    @PutMapping("/galleries/artists/arts/{artId}")
    public Art updateArt(@PathVariable("artId") int artId,@RequestBody Art art){
        return AJS.updateArt(artId, art);
    }

    @DeleteMapping("/galleries/artists/arts/{artId}")
    public void deleteArtId(@PathVariable("artId") int artId){
        AJS.deleteArtId(artId);
    }

    @GetMapping("/arts/{artId}/artist")
    public Art getArt(@PathVariable("artId") int artId){
        return AJS.getArt(artId);
    }
}