package com.dreamcricket.crickstat.controller;


import com.dreamcricket.crickstat.exception.GenericNotFoundException;
import com.dreamcricket.crickstat.model.Player;
import com.dreamcricket.crickstat.model.Roster;
import com.dreamcricket.crickstat.repository.PlayerRepository;
import com.dreamcricket.crickstat.repository.RosterRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PlayerController {


    @Autowired
    private PlayerRepository playerRepository;
    private RosterRepository rosterRepository;


    @GetMapping(path = "/players")
    public List<Player> retrieveAllPlayers() {

        return playerRepository.findAll();
    }

    @GetMapping(path = "/players/{id}")
    public Resource<Player> retrieveAllPlayers(@PathVariable int id) {
        Optional<Player> player = playerRepository.findById(id);

        if (!player.isPresent()) {

            throw new GenericNotFoundException("id- " + id);
        }
        Resource<Player> resource = new Resource<Player>(player.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllPlayers());

        resource.add(linkTo.withRel("all-players"));

        return resource;
    }

    @PutMapping("/players")
    public ResponseEntity updatePlayer(@Valid @RequestBody Player player) {

        Player playerUpdated = playerRepository.save(player);

        return new ResponseEntity<Player>(playerUpdated, HttpStatus.OK);
    }
    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player) {
        Player savedPlayer = playerRepository.save(player);
        System.out.println(savedPlayer);
        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedPlayer.getId()).toUri();
        System.out.println(location);
        ResponseEntity responseEntity = ResponseEntity.created(location).build();
        System.out.println(responseEntity.getBody());
        return savedPlayer;
    }


    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerRepository.deleteById(id);


    }




    /*@PostMapping("/players/{id}/booking")
    public ResponseEntity createBooking(@PathVariable int id, @RequestBody Booking booking) {
        Optional<Player> playerOptional = playerRepository.findById(id);

        if (!playerOptional.isPresent()) {

            throw new GenericNotFoundException("id- " + id);
        }

        Player player = playerOptional.get();

        booking.setBookingBy(player);

        bookingRepository.save(booking);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(booking.getId()).toUri();

        return ResponseEntity.created(location).build();
    }*/


}
