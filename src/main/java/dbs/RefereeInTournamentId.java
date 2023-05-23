package dbs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RefereeInTournamentId implements Serializable {
    @Column(name = "referee_id")
    private Integer refereeId;

    @Column(name = "tournament_id")
    private Integer tournamentId;

    // Default constructor
    public RefereeInTournamentId() {
    }

    // Parameterized constructor
    public RefereeInTournamentId(Integer refereeId, Integer tournamentId) {
        this.refereeId = refereeId;
        this.tournamentId = tournamentId;
    }

    // Getters and setters

    public Integer getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Integer refereeId) {
        this.refereeId = refereeId;
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
        RefereeInTournamentId that = (RefereeInTournamentId) o;
        return Objects.equals(refereeId, that.refereeId) &&
                Objects.equals(tournamentId, that.tournamentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refereeId, tournamentId);
    }
}

