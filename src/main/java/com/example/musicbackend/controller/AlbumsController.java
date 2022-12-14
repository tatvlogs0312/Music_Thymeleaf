package com.example.musicbackend.controller;

import com.example.musicbackend.request.SearchRequest;
import com.example.musicbackend.service.AlbumsService;
import com.example.musicbackend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
public class AlbumsController {

    @Autowired private AlbumsService albumsService;

    @Autowired private SongService songService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("albums",albumsService.getAllAlbums());
        return "albums";
    }

    @GetMapping("/detail/{id}")
    public String getAlbumsById(Model model, @PathVariable String id){
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("albums",albumsService.getAlbumsById(id));
        model.addAttribute("songs", songService.getSongByAlums(id));
        return "albumsdetail";
    }
}
