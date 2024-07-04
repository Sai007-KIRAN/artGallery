package com.example.artgallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.artgallery.model.*;
import com.example.artgallery.repository.*;
import java.util.*;

@Service
public class ArtistJpaService implements ArtistRepository {

    @Autowired
    private ArtistJpaRepository AJR;

    @Autowired
    private GalleryJpaRepository GJR;

    @Autowired
    private ArtJpaRepository ArtJR;

    @Override
    public ArrayList<Artist> getAllArtist() {
        List<Artist> artist = AJR.findAll();
        ArrayList<Artist> allArtist = new ArrayList<>(artist);
        return allArtist;
    }

    @Override
    public Artist getArtistById(int artistId) {
        try {
            Artist artist = AJR.findById(artistId).get();
            return artist;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Artist addArtistById(Artist artist) {
        List<Integer> artistsIds = new ArrayList<>();
        for (Gallery gallery : artist.getGalleries()) {
            artistsIds.add(gallery.getGalleryId());
        }
        List<Gallery> galleries = GJR.findAllById(artistsIds);
        if (galleries.size() != artistsIds.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        artist.setGalleries(galleries);
        return AJR.save(artist);
    }

    @Override
    public Artist updateArtist(int artistId, Artist artist) {
        try {
            Artist newArtist = AJR.findById(artistId).get();
            if (artist.getArtistName() != null) {
                newArtist.setArtistName(artist.getArtistName());
            }
            if (artist.getGenre() != null) {
                newArtist.setGenre(artist.getGenre());
            }
            if (artist.getGalleries() != null) {
                List<Integer> artistsIds = new ArrayList<>();
                for (Gallery gallery : artist.getGalleries()) {
                    artistsIds.add(gallery.getGalleryId());
                }
                List<Gallery> galleries = GJR.findAllById(artistsIds);
                if (galleries.size() != artistsIds.size()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }
                newArtist.setGalleries(galleries);
            }
            return AJR.save(newArtist);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public void deleteArtist(int artistId) {
        try {
            AJR.deleteById(artistId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    // API12 - Please Check
    @Override 
    public Artist getArtistArts(int artistId){
        try{
            Artist artist = AJR.findById(artistId).get();
            return ArtJR.findByArtist(artist);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Artist getArtistGalleries(int artistId) {
        try {
            Artist artist = AJR.findById(artistId).get();
            return artist.getGalleries();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}