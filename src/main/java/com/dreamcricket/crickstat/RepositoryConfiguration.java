package com.dreamcricket.crickstat;

import com.dreamcricket.crickstat.model.Player;
import com.dreamcricket.crickstat.model.Roster;
import com.dreamcricket.crickstat.model.Team;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Player.class);
        config.exposeIdsFor(Roster.class);
        config.exposeIdsFor(Team.class);
    }
}
