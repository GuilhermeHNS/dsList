package io.github.GuilhermeHNS.dsList.controllers;

import io.github.GuilhermeHNS.dsList.dto.GameListDTO;
import io.github.GuilhermeHNS.dsList.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity findAll() {
        List<GameListDTO> responseList = gameListService.findAll();
        return ResponseEntity.ok(responseList);
    }
}
