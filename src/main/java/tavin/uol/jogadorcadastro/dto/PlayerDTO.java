package tavin.uol.jogadorcadastro.dto;

import jakarta.persistence.Column;
import tavin.uol.jogadorcadastro.model.GroupPlayer;

public record PlayerDTO(String name, String email, String phone,String codName, GroupPlayer groupPlayer) {
}
