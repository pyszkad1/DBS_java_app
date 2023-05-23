package dbs;
import jakarta.persistence.*;

@Entity
@Table(
        name = "Club",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "address"})
)
public class Club {
    @Id
    @Column(name = "club_number")
    private Integer clubNumber;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(length = 255)
    private String federation;

    // Default constructor
    public Club() {
    }

    // Parameterized constructor
    public Club(Integer clubNumber, String name, String address, String federation) {
        this.clubNumber = clubNumber;
        this.name = name;
        this.address = address;
        this.federation = federation;
    }

    // Getters and setters

    public Integer getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(Integer clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFederation() {
        return federation;
    }

    public void setFederation(String federation) {
        this.federation = federation;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clubNumber=" + clubNumber +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", federation='" + federation + '\'' +
                '}';
    }
}

