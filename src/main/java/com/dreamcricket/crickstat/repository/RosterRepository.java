package com.dreamcricket.crickstat.repository;


import com.dreamcricket.crickstat.model.Player;
import com.dreamcricket.crickstat.model.Roster;
import com.dreamcricket.crickstat.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RosterRepository extends JpaRepository<Roster,Integer> {


}
