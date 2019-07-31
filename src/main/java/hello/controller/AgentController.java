package hello.controller;

import hello.model.Login;
import hello.repository.AgentRepository;
import hello.model.Agent;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4000", allowedHeaders = "*")
public class AgentController {


    @Autowired
    private AgentRepository agentRepo;

    @ApiOperation(value = "Kreiraj novog")
    @PutMapping("/register")
    Agent createNewAgent(@RequestBody Agent agent) {
        return agentRepo.save(agent);
    }

    @ApiOperation(value = "Login postojeceg korisnika")
    @PutMapping("/login")
    public Agent login(@RequestBody @NotNull Login login) {
        Agent agent = agentRepo.findByUsername(login.getUsername());
        if(agent == null ){
            throw new RuntimeException("Korisnik nije pronaden.");
        }
        if(!agent.getPassword().equals(login.getPassword())){
            throw new RuntimeException("Pogresna sifra.");
        }

        System.out.println(login.getPassword());

        return agent;
    }


//    //create
//    @ApiOperation(value = "Kreiraj novog")
//    @PostMapping("/agent")
//    Agent createAgent(@RequestBody Agent agent){
//        return agentRepo.save(agent);
//    }
//
//    //read
//    @ApiOperation(value = "Dohvati sve")
//    @GetMapping("/")
//    public Iterable<Agent> getAllAgents(){
//        return agentRepo.findAll();
//    }
//
//    //update
//    @ApiOperation(value = "Uredi")
//    @ApiParam(format = "application/json")
//    @PutMapping("/agent/edit/{id}")
////    Agent updateAgent(@RequestBody Agent agent){
////        return agentRepo.save(agent);
////    }
//    public ResponseEntity<Agent> updateAgent(@PathVariable Integer id, @RequestBody Agent agent){
//        return agentRepo.findById(id)
//                .map(record -> {
//                    record.setName(agent.getName());
//                    record.setArea(agent.getArea());
//                    Agent updated = agentRepo.save(record);
//                    return ResponseEntity.ok().body(updated);
//                }).orElse(ResponseEntity.notFound().build());
//    }
//
//    //delete
//    @ApiOperation(value = "Izbrisi agenta pomocu ID-a")
//    @DeleteMapping("/agent/{id}") void deleteAgent(@PathVariable Integer id){
//        agentRepo.deleteById(id);
//    }
//
//
//    //findbyID
//    @ApiOperation(value = "Dohvati agenta pomocu ID-a")
//    @GetMapping("/agent/{id}")
//    Optional<Agent> findAgentWithID(@PathVariable Integer id){
//        return agentRepo.findById(id);
//    }

}
