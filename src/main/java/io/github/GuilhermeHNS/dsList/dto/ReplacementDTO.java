package io.github.GuilhermeHNS.dsList.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ReplacementDTO(
        @NotNull(message = "O valor não pode ser nulo")
        @Min(value = 0, message = "A posição inicial não pode ser menor que 0!")
        Integer sourceIndex,
        @NotNull
        @Min(value = 0, message = "A posição de destino não pode ser menor que 0!")
        Integer destinationIndex
) {
}
