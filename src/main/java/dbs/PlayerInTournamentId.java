package dbs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayerInTournamentId implements Serializable {
    @Column(name = "player_number")
    private Integer playerNumber;

    @Column(name = "tournament_id")
    private Integer tournamentId;

    // Default constructor
    public PlayerInTournamentId() {
    }

    // Parameterized constructor
    public PlayerInTournamentId(Integer playerNumber, Integer tournamentId) {
        this.playerNumber = playerNumber;
        this.tournamentId = tournamentId;
    }

    // Getters and setters

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerInTournamentId that = (PlayerInTournamentId) o;
        return Objects.equals(playerNumber, that.playerNumber) &&
                Objects.equals(tournamentId, that.tournamentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNumber, tournamentId);
    }
}

