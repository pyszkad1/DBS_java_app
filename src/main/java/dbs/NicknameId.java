package dbs;

import java.io.Serializable;
import java.util.Objects;

public class NicknameId implements Serializable {
    private Integer player;
    private String nickname;

    // Default constructor
    public NicknameId() {
    }

    // Parameterized constructor
    public NicknameId(Integer player, String nickname) {
        this.player = player;
        this.nickname = nickname;
    }

    // Getters and setters

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(Integer player) {
        this.player = player;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NicknameId that = (NicknameId) o;
        return Objects.equals(player, that.player) &&
                Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, nickname);
    }
}


