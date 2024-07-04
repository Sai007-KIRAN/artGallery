package com.example.artgallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.artgallery.model.*;
import com.example.artgallery.repository.*;
import java.util.*;

@Service
public class GalleryJpaService implements GalleryRepository {

    @Autowired
    private GalleryJpaRepository GJR;

    @Autowired
    private ArtistJpaRepository AJR;

    public ArrayList<Gallery> getAllGallery() {
        List<Gallery> listGallery = GJR.findAll();
        ArrayList<Gallery> arrayGallery = new ArrayList<>(listGallery);
        return arrayGallery;
    }

    public Gallery getGalleryById(int galleryId) {
        try {
            Gallery gallery = GJR.findById(galleryId).get();
            return gallery;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Gallery addGallery(Gallery gallery) {
        List<Integer> artistIds = new ArrayList<>();
        for (Artist artist : gallery.getArtists()) {
            artistIds.add(artist.getArtistId());
        }
        List<Artist> artists = AJR.findAllById(artistIds);
        gallery.setArtists(artists);

        for (Artist artist : artists) {
            artist.getGalleries().add(gallery);
        }
        Gallery gall = GJR.save(gallery);
        AJR.saveAll(artists);
        return gall;
    }

    public Gallery updateGallery(int galleryId, Gallery gallery) {
        try {
            Gallery newGall = GJR.findById(galleryId).get();
            if (gallery.getGalleryName() != null) {
                newGall.setGalleryName(gallery.getGalleryName());
            }
            if (gallery.getLocation() != null) {
                newGall.setLocation(gallery.getLocation());
            }
            if (gallery.getArtists() != null) {
                List<Artist> artists = newGall.getArtists();
                for (Artist artist : artists) {
                    artist.getGalleries().remove(newGall);
                }
                AJR.saveAll(artists);
                List<Integer> pId = new ArrayList<>();
                for (Artist artist : gallery.getArtists()) {
                    pId.add(artist.getArtistId());
                }
                List<Artist> newArtist = AJR.findAllById(pId);
                for (Artist artist : newArtist) {
                    artist.getGalleries().add(newGall);
                }
                AJR.saveAll(newArtist);
                newGall.setArtists(newArtist);
            }
            return GJR.save(newGall);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteGallery(int galleryId) {
        try {
            Gallery gallery = GJR.findById(galleryId).get();
            List<Artist> artist = gallery.getArtists();
            for (Artist artists : artist) {
                artists.getGalleries().remove(gallery);
            }
            AJR.saveAll(artist);
            GJR.deleteById(galleryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    public List<Artist> getArtistGallery(int galleryId) {
        try {
            Gallery gallery = GJR.findById(galleryId).get();
            return gallery.getArtists();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}