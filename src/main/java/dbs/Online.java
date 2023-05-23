package dbs;

import jakarta.persistence.*;

@Entity
@Table(name = "Online")
public class Online {
    @Id
    @Column(name = "tournament_id")
    private Integer tournamentId;

    @Column(name = "website", length = 255, nullable = false)
    private String website;

    // Default constructor
    public Online() {
    }

    // Parameterized constructor
    public Online(Integer tournamentId, String website) {
        this.tournamentId = tournamentId;
        this.website = website;
    }

    // Getters and setters

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Online{" +
                "tournamentId=" + tournamentId +
                ", website='" + website + '\'' +
                '}';
    }
}

