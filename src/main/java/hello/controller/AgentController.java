package hello.controller;

import hello.model.Login;
import hello.model.Agent;
import io.swagger.annotations.*;
import hello.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
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
