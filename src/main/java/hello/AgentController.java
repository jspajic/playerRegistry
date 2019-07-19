package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AgentController {

    @Autowired

    private AgentRepository agentRepo;

//    @GetMapping(path = "/add")
//    public @ResponseBody String addNewAgent(@RequestParam Integer code,@RequestParam String name, @RequestParam String area){
//        Agents a = new Agents();
//        a.setCode(code);
//        a.setName(name);
//        a.setArea(area);
//        agentRepo.save(a);
//
//        return "Saved!";
//    }
    @GetMapping(path = "/agents")
    public @ResponseBody Iterable<Agents> getAllAgents(){
        return agentRepo.findAll();
    }
}
