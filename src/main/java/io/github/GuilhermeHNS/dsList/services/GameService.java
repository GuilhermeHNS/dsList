package io.github.GuilhermeHNS.dsList.services;

import io.github.GuilhermeHNS.dsList.dto.GameMinDTO;
import io.github.GuilhermeHNS.dsList.entities.Game;
import io.github.GuilhermeHNS.dsList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> gameList = gameRepository.findAll();
        return gameList.stream()
                .map(x -> new GameMinDTO(x.getId(),
                        x.getTitle(),
                        x.getYear(),
                        x.getImgUrl(),
                        x.getShortDescription())).toList();
    }
}
