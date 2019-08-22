package hello.service;

import hello.model.Agent;
import hello.model.Login;
import hello.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//TODO izbirsati nakon sto se povezem s bazom!
@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        if("jspajic".equals(username)){
//            return new User("jspajic", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("Korisnik sa tim korisnickim imenom nije pronaden!");
//        }
        Agent user = agentRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Nije pronaden korisnik s tim korisnickim imenom");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
