//package hello.controller;
//
//import hello.model.Login;
//import hello.model.Agent;
//import io.swagger.annotations.*;
//import hello.repository.AgentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.constraints.NotNull;
//
//
//@RestController
//@RequestMapping("/")
//@CrossOrigin(origins = "http://localhost:4000", allowedHeaders = "*")
//public class AgentController {
//
//    @Autowired
//    private AgentRepository agentRepo;
//
//    @ApiOperation(value = "Kreiraj novog")
//    @PutMapping("/register")
//    Agent createNewAgent(@RequestBody Agent agent) {
//
//        Agent newAgent = new Agent();
//        newAgent.setName(agent.getName());
//        newAgent.setUsername(agent.getUsername());
//        newAgent.setEmail(agent.getEmail());
//        newAgent.setPassword(agent.getPassword());
//
//        return agentRepo.save(newAgent);
//    }
//
//    @ApiOperation(value = "Login postojeceg korisnika")
//    @PutMapping("/login")
//    public Login login(@RequestBody @NotNull Login login) {
//        Agent agent = agentRepo.findByUsername(login.getUsername());
//        login.setId(agent.getId());
//        if (agent == null) {
//            throw new RuntimeException("Korisnik nije pronaden.");
//        }
//        if (login.getPassword() != agent.getPassword()) {
//            throw new RuntimeException("Pogresna sifra.");
//        }
//
//        return login;
//    }
//
//
//    @RequestMapping(value = "/logout", method = RequestMethod.POST)
//    public void logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request,response,auth);
//        }
//    }
//}
