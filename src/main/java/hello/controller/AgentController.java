package hello.controller;

import hello.model.Agent;
import io.swagger.annotations.*;
import hello.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4000", allowedHeaders = "*")
public class AgentController {

    @Autowired
    private AgentRepository agentRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/agents")
    List<Agent> findAllAgents(){

        return agentRepo.findAll();
    }


    @ApiOperation(value = "Kreiraj novog")
    @PutMapping("/register")
    Agent createNewAgent(@RequestBody Agent agent) {

        Agent newAgent = new Agent();
        newAgent.setName(agent.getName());
        newAgent.setUsername(agent.getUsername());
        newAgent.setEmail(agent.getEmail());
        newAgent.setPassword(passwordEncoder.encode(agent.getPassword()));

        return agentRepo.save(newAgent);
    }

}
