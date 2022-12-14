package com.example.musicbackend.service;

import com.example.musicbackend.repository.AlbumsRepository;
import com.example.musicbackend.entity.Albums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsService {

    @Autowired private AlbumsRepository albumsRepository;

    public List<Albums> getAlbumsBySong(String id){
        Long idSong = Long.parseLong(id);
        return albumsRepository.getAllAlbumsBySong(idSong);
    }

    public Albums getAlbumsById(String id){
        Long albumsId = Long.parseLong(id);
        var album = albumsRepository.findById(albumsId);
        return album.orElse(null);
    }

    public List<Albums> getAllAlbums() {
        return albumsRepository.findAll();
    }

    public List<Albums> get6Albums() {
        return albumsRepository.getAllLimit6();
    }
}
