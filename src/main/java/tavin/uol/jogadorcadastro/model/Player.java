package tavin.uol.jogadorcadastro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tavin.uol.jogadorcadastro.dto.PlayerDTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private String phone;
    private String codName;
    private GroupPlayer groupPlayer;

    public Player(PlayerDTO dto){
        this.name = dto.name();
        this.email = dto.email();
        this.phone = dto.phone();
        this.codName = dto.codName();
        this.groupPlayer = dto.groupPlayer();
    }
}
