package dbs;

import jakarta.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "personal_number")
    private Integer personalNumber;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "club_number", referencedColumnName = "club_number", nullable = false,
            foreignKey = @ForeignKey(name = "fk_person_club",
                    foreignKeyDefinition = "FOREIGN KEY (club_number) REFERENCES Club(club_number) ON UPDATE CASCADE)"))
    private Club club;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(Integer personalNumber, String firstName, String lastName, Club club) {
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.club = club;
    }

    // Getters and setters

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personalNumber=" + personalNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", club=" + club +
                '}';
    }
}

