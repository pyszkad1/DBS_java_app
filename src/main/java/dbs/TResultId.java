package dbs;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TResultId implements Serializable {
    @Column(name = "tournament_id")
    private Integer tournamentId;

    @Column(name = "board_number")
    private Integer boardNumber;

    @Column(name = "cards", length = 104)
    private String cards;

    @Column(name = "player1")
    private Integer player1;

    @Column(name = "player2")
    private Integer player2;

    @Column(name = "player3")
    private Integer player3;

    @Column(name = "player4")
    private Integer player4;

    // Default constructor
    public TResultId() {
    }

    // Parameterized constructor
    public TResultId(Integer tournamentId, Integer boardNumber, String cards,
                     Integer player1, Integer player2, Integer player3, Integer player4) {
        this.tournamentId = tournamentId;
        this.boardNumber = boardNumber;
        this.cards = cards;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
    }

    // Getters and setters

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Integer getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(Integer boardNumber) {
        this.boardNumber = boardNumber;
    }

    public String getCards() {
        return cards;
    }

    public void setCards(String cards) {
        this.cards = cards;
    }

    public Integer getPlayer1() {
        return player1;
    }

    public void setPlayer1(Integer player1) {
        this.player1 = player1;
    }

    public Integer getPlayer2() {
        return player2;
    }

    public void setPlayer2(Integer player2) {
        this.player2 = player2;
    }

    public Integer getPlayer3() {
        return player3;
    }

    public void setPlayer3(Integer player3) {
        this.player3 = player3;
    }

    public Integer getPlayer4() {
        return player4;
    }

    public void setPlayer4(Integer player4) {
        this.player4 = player4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TResultId)) return false;
        TResultId tResultId = (TResultId) o;
        return Objects.equals(getTournamentId(), tResultId.getTournamentId()) &&
                Objects.equals(getBoardNumber(), tResultId.getBoardNumber()) &&
                Objects.equals(getCards(), tResultId.getCards()) &&
                Objects.equals(getPlayer1(), tResultId.getPlayer1()) &&
                Objects.equals(getPlayer2(), tResultId.getPlayer2()) &&
                Objects.equals(getPlayer3(), tResultId.getPlayer3()) &&
                Objects.equals(getPlayer4(), tResultId.getPlayer4());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTournamentId(), getBoardNumber(), getCards(),
                getPlayer1(), getPlayer2(), getPlayer3(), getPlayer4());
    }
}

