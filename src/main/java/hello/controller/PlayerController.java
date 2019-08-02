package hello.controller;

import hello.model.Player;

import hello.repository.PlayerRepository;

import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepo;

    //create
    @ApiOperation(value = "Kreiraj novog")
    @PostMapping("/player")
    Player createNewPlayer(@RequestBody Player player){
        return playerRepo.save(player);
    }

    //read
    @GetMapping("/players")
    @ApiOperation("Dohvati sve igrace vezane za logiranog agenta")
    public Iterable<Player> getAll(@RequestBody Integer agentID){
        return playerRepo.getAllPlayers(agentID);
    }
    //update
    @ApiOperation(value = "Uredi")
    @ApiParam(format = "application/json")
    @PutMapping("/player/edit/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player player){
        return playerRepo.findById(id)
                .map(record -> {
                    record.setName(player.getName());
                    record.setAge(player.getAge());
                    record.setClub(player.getClub());
                    record.setNet_worth(player.getNet_worth());
                    Player updated = playerRepo.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    //delete
    @DeleteMapping("/player/{id}") void deletePlayer(@PathVariable Integer id){
        playerRepo.deleteById(id);
    }


    //findbyID
    @ApiOperation(value = "Dohvati igraca pomocu ID-a")
    @GetMapping("/player/{id}")
    Optional<Player> findSinglePlayer(@PathVariable Integer id){
        return playerRepo.findById(id);
    }
}
