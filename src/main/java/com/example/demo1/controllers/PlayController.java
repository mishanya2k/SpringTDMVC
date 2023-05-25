package com.example.demo1.controllers;

import com.example.demo1.dao.PlayDAO;
import com.example.demo1.dao.PlaygroundDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PlayController {
    private final PlaygroundDAO playgroundDAO;
    private final PlayDAO playDAO;

    public PlayController(PlaygroundDAO playgroundDAO, PlayDAO playDAO) {
        this.playgroundDAO = playgroundDAO;
        this.playDAO = playDAO;
    }

    @GetMapping("/play")
    public String startToPlay(Model model) {
        model.addAttribute("parameters",playgroundDAO);
        model.addAttribute("qwe",playDAO);
        return "play";
    }
    @GetMapping("/play/result")
    public String play(Model model){
        model.addAttribute("result",playDAO.play());
        return "result";
    }
}
