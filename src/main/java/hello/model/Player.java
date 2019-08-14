package hello.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

@Entity
@Indexed
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Field
    private String name;
    private Integer age;
    @Field
    private String club;
    private int net_worth;
    @Column(name = "agentID")
    private Integer agentID;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "agentID", insertable = false, updatable = false)
    @JsonIgnore
    private Agent agent;

    @JsonIgnore
    public Agent getAgent() {
        return agent;
    }
    @JsonIgnore
    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getNet_worth() {
        return net_worth;
    }

    public void setNet_worth(int net_worth) {
        this.net_worth = net_worth;
    }

    public Integer getAgentID() {
        return agentID;
    }

    public void setAgentID(Integer agentID) {
        this.agentID = agentID;
    }
}

