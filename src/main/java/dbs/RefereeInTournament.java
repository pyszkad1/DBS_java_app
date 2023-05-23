package dbs;

import jakarta.persistence.*;

@Entity
@Table(name = "Referee_in_tournament")
public class RefereeInTournament {
    @EmbeddedId
    private RefereeInTournamentId id;

    // Default constructor
    public RefereeInTournament() {
    }

    // Parameterized constructor
    public RefereeInTournament(RefereeInTournamentId id) {
        this.id = id;
    }

    // Getters and setters

    public RefereeInTournamentId getId() {
        return id;
    }

    public void setId(RefereeInTournamentId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RefereeInTournament{" +
                "id=" + id +
                '}';
    }
}

