package tavin.uol.jogadorcadastro.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import tavin.uol.jogadorcadastro.model.GroupPlayer;
import tavin.uol.jogadorcadastro.service.CodiNameService;

@Configuration
public class CodinameConfig {

    @Autowired
    private CodiNameService service;

    public String findCodiname(GroupPlayer groupPlayer) {
        if (groupPlayer == GroupPlayer.AVANGERS){
            String firstMatch = service.getAvangersCodinameList().stream().findFirst().orElseThrow();
            this.service.getAvangersCodinameList().remove(firstMatch);
            return firstMatch;
        }

        String firstMatch = service.getJusticeLeagueCodinameList().stream().findFirst().orElseThrow();
        this.service.getAvangersCodinameList().remove(firstMatch);
        return firstMatch;
    }
}
