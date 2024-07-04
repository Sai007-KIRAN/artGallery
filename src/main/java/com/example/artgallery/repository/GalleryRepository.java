package com.example.artgallery.repository;

import java.util.*;
import com.example.artgallery.model.*;

public interface GalleryRepository {
    ArrayList<Gallery> getAllGallery();

    Gallery getGalleryById(int galleryId);

    Gallery addGallery(Gallery gallery);

    Gallery updateGallery(int galleryId, Gallery gallery);

    void deleteGallery(int galleryId);

    List<Artist> getArtistGallery(int galleryId);
}