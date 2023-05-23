package dbs;

import jakarta.persistence.*;

@Entity
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referee_id")
    private Integer refereeId;

    @Column(name = "personal_number", nullable = false)
    private Integer personalNumber;

    @Column(name = "username", nullable = false, unique = true, length = 255)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @OneToOne
    @JoinColumn(name = "personal_number", referencedColumnName = "personal_number", insertable = false, updatable = false)
    private Person person;

    // Default constructor
    public Referee() {
    }

    // Parameterized constructor
    public Referee(Integer personalNumber, String username, String password) {
        this.personalNumber = personalNumber;
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public Integer getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Integer refereeId) {
        this.refereeId = refereeId;
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Referee{" +
                "refereeId=" + refereeId +
                ", personalNumber=" + personalNumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", person=" + person +
                '}';
    }
}

