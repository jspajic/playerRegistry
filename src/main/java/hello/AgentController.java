package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
public class AgentController {

    @Autowired

    private AgentRepository agentRepo;

    @RequestMapping("/")
    public @ResponseBody Iterable<Agent> getAllAgents(){
        return agentRepo.findAll();
    }

}
