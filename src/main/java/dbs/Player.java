package dbs;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Player")
public class Player {
    @Id
    @Column(name = "player_number")
    private Integer playerNumber;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "category", nullable = false, length = 255)
    private String category;

    @OneToOne
    @JoinColumn(name = "player_number", referencedColumnName = "personal_number", insertable = false, updatable = false)
    private Person person;

    // Default constructor
    public Player() {
    }

    // Parameterized constructor
    public Player(Integer playerNumber, LocalDate dateOfBirth, String category) {
        this.playerNumber = playerNumber;
        this.dateOfBirth = dateOfBirth;
        this.category = category;
    }

    // Getters and setters

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerNumber=" + playerNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", category='" + category + '\'' +
                ", person=" + person +
                '}';
    }
}

