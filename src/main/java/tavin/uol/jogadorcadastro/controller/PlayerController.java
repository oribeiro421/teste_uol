package tavin.uol.jogadorcadastro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tavin.uol.jogadorcadastro.dto.PlayerDTO;
import tavin.uol.jogadorcadastro.model.Player;
import tavin.uol.jogadorcadastro.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public ResponseEntity<List<Player>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Player> create(@RequestBody PlayerDTO dto){
        Player player = this.service.create(dto);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
}
