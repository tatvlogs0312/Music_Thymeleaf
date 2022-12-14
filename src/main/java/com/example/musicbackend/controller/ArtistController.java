package com.example.musicbackend.controller;

import com.example.musicbackend.request.SearchRequest;
import com.example.musicbackend.service.ArtistService;
import com.example.musicbackend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private SongService songService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("artists", artistService.getArtists());
        return "artist";
    }

    @GetMapping("/detail/{id}")
    public String getAlbumsById(Model model, @PathVariable String id){
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("artist",artistService.getArtistById(id));
        model.addAttribute("songs", songService.getSongByArtist(id));
        return "artistdetail";
    }


}
