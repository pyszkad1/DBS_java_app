package dbs;

import jakarta.persistence.*;


import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "Tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private Integer tournamentId;

    @ManyToOne
    @JoinColumn(name = "club_number", referencedColumnName = "club_number")
    private Club club;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    // Default constructor
    public Tournament() {
    }

    // Parameterized constructor
    public Tournament(Club club, LocalDate date, String name, Time startTime) {
        this.club = club;
        this.date = date;
        this.name = name;
        this.startTime = startTime;
    }

    // Getters and setters

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "tournamentId=" + tournamentId +
                ", club=" + club +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}

