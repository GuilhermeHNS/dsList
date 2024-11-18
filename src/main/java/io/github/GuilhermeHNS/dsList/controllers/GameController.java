package io.github.GuilhermeHNS.dsList.controllers;

import io.github.GuilhermeHNS.dsList.dto.GameMinDTO;
import io.github.GuilhermeHNS.dsList.exceptions.RestErrorMessage;
import io.github.GuilhermeHNS.dsList.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@Tag(name = "Games", description = "Endpoint para gerenciamento de Games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    @Operation(summary = "Busca todos os games",
            description = "Busca todos os games registrados",
            tags = {"Games"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Games encontrados com sucesso!", content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GameMinDTO.class))
                    )),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RestErrorMessage.class)
                    ))})
    public ResponseEntity findAll() {
        List<GameMinDTO> gameList = gameService.findAll();
        return ResponseEntity.ok(gameList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um game por ID",
            description = "Busca um game pelo seu ID",
            tags = {"Games"},
            parameters = @Parameter(name = "id", description = "ID do Game", example = "1", in = ParameterIn.PATH, required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Game encontrado com sucesso!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GameMinDTO.class)
                    )),
                    @ApiResponse(responseCode = "404", description = "Não encontrado!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RestErrorMessage.class)
                    )),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RestErrorMessage.class)
                    ))
            })
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }
}
