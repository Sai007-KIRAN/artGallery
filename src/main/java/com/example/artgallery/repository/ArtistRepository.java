package com.example.artgallery.repository;

import java.util.*;
import com.example.artgallery.model.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository {
    ArrayList<Artist> getAllArtist();

    Artist getArtistById(int artistId);

    Artist addArtistById(Artist artist);

    Artist updateArtist(int artistId, Artist artist);

    void deleteArtist(int artistId);

    Artist getArtistArts(int artistId); //API-12

    Artist getArtistGalleries(int artistId);
}