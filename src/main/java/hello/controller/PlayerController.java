package hello.controller;

import hello.model.Player;

import hello.repository.PlayerRepository;

import io.swagger.annotations.*;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4000/")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private EntityManager entityManager;

    //create
    @ApiOperation(value = "Kreiraj novog")
    @PostMapping("/player")
    Player createNewPlayer(@RequestBody Player player){
        return playerRepo.save(player);
    }

    @GetMapping(value = "/players")
    @ApiOperation("Dohvati sve igrace")
    public Iterable<Player> getAll(){
        return playerRepo.findAll();
    }

    //update
    @ApiOperation(value = "Uredi")
    @ApiParam(format = "application/json")
    @PutMapping("/player/edit/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody Player player){
        return playerRepo.findById(id)
                .map(record -> {
                    record.setName(player.getName());
                    record.setAge(player.getAge());
                    record.setClub(player.getClub());
                    record.setNet_worth(player.getNet_worth());
                    Player updated = playerRepo.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/player/{id}")
    public void removePlayer(@PathVariable("id")Integer id){
        playerRepo.removePlayer(id);
    }


    //findbyID
    @ApiOperation(value = "Dohvati igraca pomocu ID-a")
    @GetMapping("/player/{id}")
    public Optional<Player> findSinglePlayer(@PathVariable Integer id){
        Optional<Player> player = playerRepo.findById(id);

        return player;
    }



    @ApiOperation(value = "Pretrazivanje igraca po imenu ili klubu")
    @GetMapping("/search")
    public List<Player> searchPlayerByName(@RequestParam String searchTerm){
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        //create hibernate search query
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(Player.class)
                .get();

        //generate a lucene query
        Query query = queryBuilder
                .keyword()
                .onFields("name","club").matching(searchTerm)
                .createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Player.class);

        List<Player> playersMatching = fullTextQuery.getResultList();

        return playersMatching;
    }
}
