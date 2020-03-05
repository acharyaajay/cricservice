package com.dreamcricket.crickstat.controller;


import com.dreamcricket.crickstat.exception.GenericNotFoundException;
import com.dreamcricket.crickstat.model.Player;
import com.dreamcricket.crickstat.model.Roster;
import com.dreamcricket.crickstat.model.Team;
import com.dreamcricket.crickstat.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TeamController {


    @Autowired
    private TeamRepository teamRepository;


    @GetMapping(path = "/teams")
    public List<Team> retrieveAllTeams() {

        return teamRepository.findAll();
    }

    @GetMapping(path = "/teams/{id}")
    public Resource<Team> retrieveAllTeams(@PathVariable int id) {
        Optional<Team> team = teamRepository.findById(id);

        if (!team.isPresent()) {

            throw new GenericNotFoundException("id- " + id);
        }
        Resource<Team> resource = new Resource<Team>(team.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllTeams());

        resource.add(linkTo.withRel("all-teams"));

        return resource;
    }

    @PostMapping("/teams")
    public ResponseEntity createTeam(@Valid @RequestBody Team team) {
        Team savedTeam = teamRepository.save(team);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedTeam.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Integer id) {
        teamRepository.deleteById(id);


    }


    /*@GetMapping(path = "/players/{id}/bookings")
    public List<Booking> retrieveTeamsPosts(@PathVariable int id) {

        Optional<Team> player = playerRepository.findById(id);
        if (!player.isPresent()) {

            throw new GenericNotFoundException("id- " + id);
        }
        return player.get().getBookings();
    }


    @PostMapping("/players/{id}/booking")
    public ResponseEntity createBooking(@PathVariable int id, @RequestBody Booking booking) {
        Optional<Team> playerOptional = playerRepository.findById(id);

        if (!playerOptional.isPresent()) {

            throw new GenericNotFoundException("id- " + id);
        }

        Team player = playerOptional.get();

        booking.setBookingBy(player);

        bookingRepository.save(booking);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(booking.getId()).toUri();

        return ResponseEntity.created(location).build();
    }*/


}
