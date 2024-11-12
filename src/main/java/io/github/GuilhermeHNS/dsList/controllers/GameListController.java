package io.github.GuilhermeHNS.dsList.controllers;

import io.github.GuilhermeHNS.dsList.dto.GameListDTO;
import io.github.GuilhermeHNS.dsList.dto.GameMinDTO;
import io.github.GuilhermeHNS.dsList.services.GameListService;
import io.github.GuilhermeHNS.dsList.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity findAll() {
        List<GameListDTO> responseList = gameListService.findAll();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{idList}/games")
    public ResponseEntity findByList(@PathVariable Long idList) {
        List<GameMinDTO> gameList = gameService.findByList(idList);
        return ResponseEntity.ok(gameList);
    }
}
