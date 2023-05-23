package dbs;

import jakarta.persistence.*;

@Entity
@Table(name = "Coaches")
@IdClass(CoachesId.class)
public class Coaches {
    @Id
    @ManyToOne
    @JoinColumn(name = "coach", referencedColumnName = "player_number")
    private Player coach;

    @Id
    @ManyToOne
    @JoinColumn(name = "player", referencedColumnName = "player_number")
    private Player player;

    // Default constructor
    public Coaches() {
    }

    // Parameterized constructor
    public Coaches(Player coach, Player player) {
        this.coach = coach;
        this.player = player;
    }

    // Getters and setters

    public Player getCoach() {
        return coach;
    }

    public void setCoach(Player coach) {
        this.coach = coach;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coach=" + coach +
                ", player=" + player +
                '}';
    }
}


