package dbs;

import jakarta.persistence.*;

@Entity
@Table(name = "Live")
public class Live {
    @Id
    @Column(name = "tournament_id")
    private Integer tournamentId;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    // Default constructor
    public Live() {
    }

    // Parameterized constructor
    public Live(Integer tournamentId, String address) {
        this.tournamentId = tournamentId;
        this.address = address;
    }

    // Getters and setters

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Live{" +
                "tournamentId=" + tournamentId +
                ", address='" + address + '\'' +
                '}';
    }
}

