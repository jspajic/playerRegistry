package hello.repository;

import hello.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PlayerRepository extends JpaRepository<Player, Integer> {

}


