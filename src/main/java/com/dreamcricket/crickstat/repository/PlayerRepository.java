package com.dreamcricket.crickstat.repository;


import com.dreamcricket.crickstat.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {


}
