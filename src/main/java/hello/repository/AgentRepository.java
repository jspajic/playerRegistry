package hello.repository;

import hello.model.Agent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AgentRepository extends JpaRepository<Agent, Integer> {
    @Query(value = "SELECT * FROM agent WHERE username = :username", nativeQuery = true)
    Agent findByUsername(@Param("username")String username);


}


