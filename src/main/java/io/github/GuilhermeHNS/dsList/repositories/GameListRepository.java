package io.github.GuilhermeHNS.dsList.repositories;

import io.github.GuilhermeHNS.dsList.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
