package io.github.GuilhermeHNS.dsList.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_beloging")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Beloging {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private BelogingPK id = new BelogingPK();

    private Integer position;
}
