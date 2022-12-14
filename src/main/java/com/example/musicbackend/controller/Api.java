package com.example.musicbackend.controller;

import com.example.musicbackend.entity.Song;
import com.example.musicbackend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Api {

    @Autowired private SongService songService;

    @GetMapping("/song")
    public ResponseEntity<Object> getAllSong(){
        List<Song> songList = songService.getAllSongs();
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }
}
