package hello.controller;

import hello.repository.AgentRepository;
import hello.model.Agent;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4000", allowedHeaders = "*")
public class AgentController {


    @Autowired
    private AgentRepository agentRepo;

    //create
    @ApiOperation(value = "Kreiraj novog")
    @PostMapping("/agent")
    Agent createAgent(@RequestBody Agent agent){
        return agentRepo.save(agent);
    }

    //read
    @ApiOperation(value = "Dohvati sve")
    @GetMapping("/")
    public Iterable<Agent> getAllAgents(){
        return agentRepo.findAll();
    }

    //update
    @ApiOperation(value = "Uredi")
    @ApiParam(format = "application/json")
    @PutMapping("/agent/edit/{id}")
//    Agent updateAgent(@RequestBody Agent agent){
//        return agentRepo.save(agent);
//    }
    public ResponseEntity<Agent> updateAgent(@PathVariable Integer id, @RequestBody Agent agent){
        return agentRepo.findById(id)
                .map(record -> {
                    record.setName(agent.getName());
                    record.setArea(agent.getArea());
                    Agent updated = agentRepo.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    //delete
    @ApiOperation(value = "Izbrisi agenta pomocu ID-a")
    @DeleteMapping("/agent/{id}") void deleteAgent(@PathVariable Integer id){
        agentRepo.deleteById(id);
    }


    //findbyID
    @ApiOperation(value = "Dohvati agenta pomocu ID-a")
    @GetMapping("/agent/{id}")
    Optional<Agent> findAgentWithID(@PathVariable Integer id){
        return agentRepo.findById(id);
    }

}
