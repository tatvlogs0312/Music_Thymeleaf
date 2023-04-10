package com.example.musicbackend.controller;

import com.example.musicbackend.request.SearchRequest;
import com.example.musicbackend.service.AlbumsService;
import com.example.musicbackend.service.ArtistService;
import com.example.musicbackend.service.SongService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private SongService songService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumsService albumsService;

    @GetMapping("/{idSong}")
    public String playMusic(Model model, @PathVariable String idSong, HttpServletRequest request) {
        String user = "anonymous";
        if (request.getUserPrincipal() != null){
            user = request.getUserPrincipal().getName();
        }
        System.out.println("User : " + user);
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("song",songService.getSongById(idSong));
        model.addAttribute("artist",artistService.getArtistBySong(idSong));
        model.addAttribute("others",songService.getSongOtherBySongId(idSong));
        return "music";
    }

    @GetMapping(value = "search")
    public String findByKeyWord(@ModelAttribute("request") SearchRequest request, Model model){
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("songs",songService.getSongByKeyWord(request.getSearch()));
        return "search";
    }
}
