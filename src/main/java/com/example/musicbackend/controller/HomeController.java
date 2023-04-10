package com.example.musicbackend.controller;

import com.example.musicbackend.dto.UserDTO;
import com.example.musicbackend.request.SearchRequest;
import com.example.musicbackend.service.AlbumsService;
import com.example.musicbackend.service.ArtistService;
import com.example.musicbackend.service.SongService;
import com.example.musicbackend.service.user.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {

    @Autowired
    private SongService songService;

    @Autowired
    private AlbumsService albumsService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String home(Model model, HttpServletRequest request) {
        if (request.getUserPrincipal() != null){
            UserDTO userDTO = userService.me(request.getUserPrincipal().getName());
            model.addAttribute("user",userDTO);
            System.out.println(userDTO.getEmail() + " - " + userDTO.getUsername());
        }
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("populars", songService.getSubPopular());
        model.addAttribute("news", songService.getSongNew());
        model.addAttribute("albums", albumsService.get6Albums());
        model.addAttribute("artists",artistService.get6Artists());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
