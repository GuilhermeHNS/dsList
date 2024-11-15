package io.github.GuilhermeHNS.dsList.services;

import io.github.GuilhermeHNS.dsList.dto.GameDTO;
import io.github.GuilhermeHNS.dsList.dto.GameMinDTO;
import io.github.GuilhermeHNS.dsList.entities.Game;
import io.github.GuilhermeHNS.dsList.projections.GameMinProjection;
import io.github.GuilhermeHNS.dsList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> gameList = gameRepository.findAll();
        return gameList.stream()
                .map(x -> new GameMinDTO(x.getId(),
                        x.getTitle(),
                        x.getYear(),
                        x.getImgUrl(),
                        x.getShortDescription())).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        if(game.isPresent()) {
            return new GameDTO(game.get());
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long idList) {
        List<GameMinProjection> response = gameRepository.searchByList(idList);
        return response.stream()
                .map(x -> new GameMinDTO(
                        x.getId(),
                        x.getTitle(),
                        x.getGameYear(),
                        x.getImgUrl(),
                        x.getShortDescription())).toList();
    }
}
