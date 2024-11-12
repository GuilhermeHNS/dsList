package io.github.GuilhermeHNS.dsList.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tb_belonging")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Belonging {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private BelongingPK id = new BelongingPK();

    private Integer position;
}
