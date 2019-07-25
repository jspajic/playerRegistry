package hello.controller;

import hello.repository.AgentRepository;
import hello.model.Agent;
import io.swagger.annotations.ExampleProperty;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/")
public class AgentController {


    @Autowired
    private AgentRepository agentRepo;

    //create
    @PostMapping("/agent")
    Agent createAgent(@RequestBody Agent agent){
        return agentRepo.save(agent);
    }


    //read
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4000")
    public Iterable<Agent> getAllAgents(){
        return agentRepo.findAll();
    }

    //update
    @PutMapping("/agent")
    Agent updateAgent(@RequestBody Agent agent){
        return agentRepo.save(agent);
    }

    //delete
    @CrossOrigin(origins = "http://localhost:4000")
    @DeleteMapping("/agent/{id}") void deleteAgent(@PathVariable Integer id){
        agentRepo.deleteById(id);
    }

    @GetMapping("/agent/{id}")
    Optional<Agent> findAgentWithID(@PathVariable Integer id){
        return agentRepo.findById(id);
    }
}
