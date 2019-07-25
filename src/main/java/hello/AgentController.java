package hello;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/")
public class AgentController {


    @Autowired
    private AgentRepository agentRepo;

    //create
    @PostMapping("/agent") Agents createAgent(@RequestBody Agents agent){
        return agentRepo.save(agent);
    }


    //read
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4000")
    public Iterable<Agents> getAllAgents(){
        return agentRepo.findAll();
    }

    //update
    @PutMapping("/agent") Agents updateAgent(@RequestBody Agents agent){
        return agentRepo.save(agent);
    }

    //delete
    @CrossOrigin(origins = "http://localhost:4000")
    @DeleteMapping("/agent/{id}") void deleteAgent(@PathVariable Integer id){
        agentRepo.deleteById(id);
    }

    @GetMapping("/agent/{id}")
    Optional<Agents> findAgentWithID(@PathVariable Integer id){
        return agentRepo.findById(id);
    }
}
