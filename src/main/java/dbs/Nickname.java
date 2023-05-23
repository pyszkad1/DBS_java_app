package dbs;

import jakarta.persistence.*;

@Entity
@IdClass(NicknameId.class)
@Table(name = "Nickname")
public class Nickname {
    @Id
    @ManyToOne
    @JoinColumn(name = "player_number", referencedColumnName = "player_number")
    private Player player;

    @Id
    @Column(name = "nickname", length = 255)
    private String nickname;

    // Default constructor
    public Nickname() {
    }

    // Parameterized constructor
    public Nickname(Player player, String nickname) {
        this.player = player;
        this.nickname = nickname;
    }

    // Getters and setters

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Nickname{" +
                "player=" + player +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
