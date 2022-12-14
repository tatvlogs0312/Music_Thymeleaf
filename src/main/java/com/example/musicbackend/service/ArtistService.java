package com.example.musicbackend.service;

import com.example.musicbackend.repository.ArtistRepository;
import com.example.musicbackend.entity.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired private ArtistRepository artistRepository;

    public List<Artist> getArtists(){
        return artistRepository.findAll();
    }

    public Artist getArtistBySong(String id){
        Long songId = Long.parseLong(id);
        Optional<Artist> artist = artistRepository.findArtistBySongId(songId);
        return artist.orElse(null);
    }

    public Artist getArtistById(String id) {
        Long artistId = Long.parseLong(id);
        var artist = artistRepository.findById(artistId);
        return artist.orElse(null);
    }
}
