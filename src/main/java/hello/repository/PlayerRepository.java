package hello.repository;

import hello.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PlayerRepository extends JpaRepository<Player, Integer> {
    //    @Query(value = "SELECT * FROM player WHERE agentID = :id", nativeQuery = true)
    //    Iterable<Player> getAllPlayers(@Param("id") Integer agentID);
//
//    @Query(value = "SELECT Player.id, Player.name, Player.age, Player.club, Player.net_worth, Agent.name FROM Player INNER JOIN Agent ON Player.agentID = Agent.id WHERE Player.agentID = 2")
//    Iterable<Player> getAllPlayersForAgent();
//    @Param("id") Integer id

//    @Query("from player p"
//    + "where p.agentID = 2"
//            + "p.agent.id = ")
}


