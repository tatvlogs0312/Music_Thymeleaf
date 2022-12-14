package com.example.musicbackend.controller;

import com.example.musicbackend.request.SearchRequest;
import com.example.musicbackend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trending")
public class TrendingController {
    @Autowired
    private SongService songService;

    @GetMapping
    public String trending(Model model){
        model.addAttribute("request", new SearchRequest());
        model.addAttribute("trendings", songService.getTopTrending());
        return "trending";
    }
}
