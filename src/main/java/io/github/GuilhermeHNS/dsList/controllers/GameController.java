package io.github.GuilhermeHNS.dsList.controllers;

import io.github.GuilhermeHNS.dsList.dto.GameMinDTO;
import io.github.GuilhermeHNS.dsList.entities.Game;
import io.github.GuilhermeHNS.dsList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity findAll() {
        List<GameMinDTO> gameList = gameService.findAll();
        return ResponseEntity.ok(gameList);
    }
}
