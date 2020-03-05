package com.dreamcricket.crickstat.repository;


import com.dreamcricket.crickstat.model.Player;
import com.dreamcricket.crickstat.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {


}
