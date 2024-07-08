package com.example.artgallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.artgallery.model.*;
import com.example.artgallery.repository.*;
import java.util.*;

@Service
public class ArtJpaService implements ArtRepository {
    @Autowired
    private ArtistJpaRepository AJR;

    @Autowired
    private ArtJpaRepository ArtJR;

    @Override
    public ArrayList<Art> getAllArt() {
        List<Art> allList = ArtJR.findAll();
        ArrayList<Art> arrList = new ArrayList<>(allList);
        return arrList;
    }

    @Override
    public Art ArtById(int artId) {
        try {
            Art each = ArtJR.findById(artId).get();
            return each;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Art getAddArt(Art art) {
        Artist artist = art.getArtist();
        int pId = artist.getArtistId();
        try {
            Artist complete = AJR.findById(pId).get();
            art.setArtist(complete);
            ArtJR.save(art);
            return art;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Art updateArt(int artId, Art art) {
        try {
            Art update = ArtJR.findById(artId).get();
            if (art.getArtTitle() != null) {
                update.setArtTitle(art.getArtTitle());
            }
            if (art.getTheme() != null) {
                update.setTheme(art.getTheme());
            }
            if (art.getArtist() != null) {
                Artist artist = art.getArtist();
                int pId = artist.getArtistId();
                Artist complete = AJR.findById(pId).get();
                update.setArtist(complete);
            }
            ArtJR.save(update);
            return update;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteArtId(int artId) {
        try {
            ArtJR.deleteById(artId);
            ArtJR.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Artist getArt(int artId) {
        try {
            Art view = ArtJR.findById(artId).get();
            return view.getArtist();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
