package tavin.uol.jogadorcadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tavin.uol.jogadorcadastro.dto.PlayerDTO;
import tavin.uol.jogadorcadastro.infra.CodinameConfig;
import tavin.uol.jogadorcadastro.model.GroupPlayer;
import tavin.uol.jogadorcadastro.model.Player;
import tavin.uol.jogadorcadastro.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodinameConfig codinameConfig;

    public List<Player> getAll(){
        return this.repository.findAll();
    }

    public Player create(PlayerDTO dto){
        Player player = new Player(dto);
        String codiname = getCodiname(dto.groupPlayer());
        player.setCodName(codiname);
        return this.repository.save(player);
    }

    private String getCodiname(GroupPlayer groupPlayer){
        return this.codinameConfig.findCodiname(groupPlayer);
    }
}
