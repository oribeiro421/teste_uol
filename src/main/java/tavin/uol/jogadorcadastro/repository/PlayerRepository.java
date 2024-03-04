package tavin.uol.jogadorcadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tavin.uol.jogadorcadastro.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
