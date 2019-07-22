package hello;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AgentController {

    @Autowired
    private AgentRepository agentRepo;

    //create
    @PostMapping("/agent") Agents createAgent(@RequestBody Agents agent){
        return agentRepo.save(agent);
    }

    //read
    @GetMapping("/")
    public Iterable<Agents> getAllAgents(){
        return agentRepo.findAll();
    }

    //update
    @PutMapping("/agent") Agents updateAgent(@RequestBody Agents agent){
        return agentRepo.save(agent);
    }

    //delete
    @DeleteMapping("/agent/{id}") void deleteAgent(@PathVariable Integer id){
        agentRepo.deleteById(id);
    }


}
