package com.dreamcricket.crickstat.controller;


import com.dreamcricket.crickstat.exception.GenericNotFoundException;
import com.dreamcricket.crickstat.model.Player;
import com.dreamcricket.crickstat.model.Roster;
import com.dreamcricket.crickstat.model.Team;
import com.dreamcricket.crickstat.repository.RosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RosterController {


    @Autowired
    private RosterRepository rosterRepository;
    @GetMapping(path = "/rosters/player/{id}")
    List<Roster> findByPlayer(Integer playerId){
      List<Roster> output = new LinkedList<>();
        List<Roster> rosters = rosterRepository.findAll();
        System.out.println(playerId);
        for (Roster roster : rosters)
        {
            Player player = roster.getPlayer();
            System.out.println(player.getId());
            if (player.getId().equals(playerId))
            {
                output.add(roster);
            }
        }
        return output;
    }
    @GetMapping(path = "/rosters/teams/{id}")
    List<Roster> findByTeam(Integer teamId){
        List<Roster> output = new LinkedList<>();
        List<Roster> rosters = rosterRepository.findAll();
        for (Roster roster : rosters)
        {
            Team team = roster.getTeam();
            System.out.println(team.getId());
            if (team.getId().equals(teamId))
            {
                output.add(roster);
            }
        }
        return output;
    }

    @GetMapping(path = "/rosters")
    public List<Roster> retrieveAllRoster() {

        return rosterRepository.findAll(Sort.by(Sort.Direction.ASC,"Team"));
    }
    @PutMapping("/roster")
    public ResponseEntity updateRoster(@Valid @RequestBody Roster roster) {

        Roster rosterUpdated = rosterRepository.save(roster);

        return new ResponseEntity<Roster>(rosterUpdated, HttpStatus.OK);
    }
    @GetMapping(path = "/roster/{id}")
    public Resource<Roster> retrieveAllRoster(@PathVariable int id) {
        Optional<Roster> roster = rosterRepository.findById(id);
        if (!roster.isPresent()) {

            throw new GenericNotFoundException("id- " + id);
        }
        Resource<Roster> resource = new Resource<>(roster.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllRoster());

        resource.add(linkTo.withRel("all-rosters"));
        return resource;
    }

    @PostMapping("/rosters")
    public ResponseEntity createRoster(@Valid @RequestBody Roster roster) {
        Roster savedRoster = rosterRepository.save(roster);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedRoster.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/rosters/{id}")
    public void deleteRoster(@PathVariable Integer id) {
        rosterRepository.deleteById(id);


    }


}
