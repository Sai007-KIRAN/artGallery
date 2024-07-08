package com.example.artgallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.artgallery.model.*;

@Repository
public interface ArtRepository {
    ArrayList<Art> getAllArt();

    Art ArtById(int artId);

    Art getAddArt(Art art);

    Art updateArt(int artId, Art art);

    void deleteArtId(int artId);

    Artist getArt(int artId);

}
