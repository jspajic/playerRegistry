package hello.controller;

import hello.model.Player;

import hello.repository.PlayerRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RequestMapping("/api")
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
    @ApiOperation(value = "Dohvati sve")
    @GetMapping("/players")
    public Iterable<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    //update
    @ApiOperation(value = "Uredi")
    @ApiParam(format = "application/json")
    @PutMapping("/player/edit/{id}")
//    Agent updateAgent(@RequestBody Agent agent){
//        return agentRepo.save(agent);
//    }
//    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player player){
////        return playerRepo.findById(id)
////                .map(record -> {
////                    record.setName(agent.getName());
////                    record.setArea(agent.getArea());
////                    Agent updated = agentRepo.save(record);
////                    return ResponseEntity.ok().body(updated);
////                }).orElse(ResponseEntity.notFound().build());
//    }

    //delete
//    @ApiOperation(value = "Izbrisi igraca")
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
