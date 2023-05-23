package dbs;

import java.io.Serializable;
import java.util.Objects;

public class CoachesId implements Serializable {
    private Integer coach;
    private Integer player;

    // Default constructor
    public CoachesId() {
    }

    // Parameterized constructor
    public CoachesId(Integer coach, Integer player) {
        this.coach = coach;
        this.player = player;
    }

    // Getters and setters

    public Integer getCoach() {
        return coach;
    }

    public void setCoach(Integer coach) {
        this.coach = coach;
    }

    public Integer getPlayer() {
        return player;
    }

    public void setPlayer(Integer player) {
        this.player = player;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoachesId coachId = (CoachesId) o;
        return Objects.equals(coach, coachId.coach) &&
                Objects.equals(player, coachId.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coach, player);
    }
}
