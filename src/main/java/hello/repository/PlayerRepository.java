package hello.repository;

import hello.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "SELECT * FROM player WHERE agentID = :id", nativeQuery = true)
    Iterable<Player> getAllPlayers(@Param("id") Integer agentID);
}


