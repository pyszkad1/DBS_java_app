package dbs;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Nickname")
public class Nickname {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nickname_id")
    private Long nicknameId;

    @Column(name = "nickname", length = 255)
    private String nickname;

    @ManyToMany
    @JoinTable(
            name = "Player_Nickname",
            joinColumns = @JoinColumn(name = "nickname_id"),
            inverseJoinColumns = @JoinColumn(name = "player_number")
    )
    private Set<Player> players = new HashSet<>();

    // Default constructor
    public Nickname() {
    }

    // Parameterized constructor
    public Nickname(String nickname) {
        this.nickname = nickname;
    }

    // Getters and setters

    public Long getNicknameId() {
        return nicknameId;
    }

    public void setNicknameId(Long nicknameId) {
        this.nicknameId = nicknameId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Nickname{" +
                "nicknameId=" + nicknameId +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

