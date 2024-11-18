package io.github.GuilhermeHNS.dsList.services;

import io.github.GuilhermeHNS.dsList.exceptions.InvalidIndexException;
import io.github.GuilhermeHNS.dsList.dto.GameListDTO;
import io.github.GuilhermeHNS.dsList.projections.GameMinProjection;
import io.github.GuilhermeHNS.dsList.repositories.GameListRepository;
import io.github.GuilhermeHNS.dsList.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream()
                .map(x -> new GameListDTO(
                        x.getId(),
                        x.getName())).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        if(destinationIndex > list.size() -1) {
            throw new InvalidIndexException();
        }
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
