package dbs;

import jakarta.persistence.*;

@Entity
@Table(name = "Player_in_tournament")
public class PlayerInTournament {
    @EmbeddedId
    private PlayerInTournamentId id;

    // Default constructor
    public PlayerInTournament() {
    }

    // Parameterized constructor
    public PlayerInTournament(PlayerInTournamentId id) {
        this.id = id;
    }

    // Getters and setters

    public PlayerInTournamentId getId() {
        return id;
    }

    public void setId(PlayerInTournamentId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PlayerInTournament{" +
                "id=" + id +
                '}';
    }
}

