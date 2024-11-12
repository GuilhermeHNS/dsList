package io.github.GuilhermeHNS.dsList.dto;

public record GameMinDTO(
        Long id,
        String title,
        Integer year,
        String imgUrl,
        String shortDescription
) {
}
