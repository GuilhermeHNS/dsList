package io.github.GuilhermeHNS.dsList.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_gamelist")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;


}
