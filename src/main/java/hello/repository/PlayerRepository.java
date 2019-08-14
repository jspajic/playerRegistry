package hello.repository;

import hello.model.Player;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;


public interface PlayerRepository extends CrudRepository<Player, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Player p WHERE p.id=:id")
    void removePlayer(@Param("id") Integer id);
}


