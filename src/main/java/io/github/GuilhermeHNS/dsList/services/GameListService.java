package io.github.GuilhermeHNS.dsList.services;

import io.github.GuilhermeHNS.dsList.dto.GameListDTO;
import io.github.GuilhermeHNS.dsList.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream()
                .map(x -> new GameListDTO(
                        x.getId(),
                        x.getName())).toList();
    }

}
