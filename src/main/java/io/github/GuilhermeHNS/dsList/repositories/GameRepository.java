package io.github.GuilhermeHNS.dsList.repositories;

import io.github.GuilhermeHNS.dsList.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
