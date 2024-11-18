package io.github.GuilhermeHNS.dsList.controllers;

import io.github.GuilhermeHNS.dsList.exceptions.RestErrorMessage;
import io.github.GuilhermeHNS.dsList.dto.GameListDTO;
import io.github.GuilhermeHNS.dsList.dto.GameMinDTO;
import io.github.GuilhermeHNS.dsList.dto.ReplacementDTO;
import io.github.GuilhermeHNS.dsList.services.GameListService;
import io.github.GuilhermeHNS.dsList.services.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
@Tag(name = "ListGames", description = "Endpoint para gerenciamento de listas de jogos")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    @Operation(summary = "Busca todos as listas",
            description = "Busca todos as listas de games registrados",
            tags = {"ListGames"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Listas de Games encontradas com sucesso!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = GameListDTO.class)
                    )),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RestErrorMessage.class)
                    ))})
    public ResponseEntity findAll() {
        List<GameListDTO> responseList = gameListService.findAll();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{idList}/games")
    @Operation(summary = "Busca uma lista de games por ID",
            description = "Busca uma lista de games pelo seu ID",
            tags = {"ListGames"},
            parameters = @Parameter(name = "id", description = "ID da lista", example = "1", in = ParameterIn.PATH, required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista encontrada com sucesso!", content = @Content(
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
    public ResponseEntity findByList(@PathVariable Long idList) {
        List<GameMinDTO> gameList = gameService.findByList(idList);
        return ResponseEntity.ok(gameList);
    }

    @PostMapping(value = "/{listId}/replacement")
    @Operation(summary = "Move a posição de um jogo na lista",
            description = "Muda a posição que o jogo está em uma lista",
            tags = {"ListGames"},
            parameters = @Parameter(name = "id", description = "ID da lista", example = "1", in = ParameterIn.PATH, required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Posição alterada com sucesso!"),
                    @ApiResponse(responseCode = "404", description = "Não encontrado!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RestErrorMessage.class)
                    )),
                    @ApiResponse(responseCode = "500", description = "Erro interno no servidor!", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RestErrorMessage.class)
                    ))
            })
    public ResponseEntity move(@PathVariable Long listId, @Valid @RequestBody ReplacementDTO dto) {
        gameListService.move(listId, dto.sourceIndex(), dto.destinationIndex());
        return ResponseEntity.ok().build();
    }
}
