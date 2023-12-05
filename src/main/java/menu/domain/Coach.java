package menu.domain;

import java.util.Objects;

public class Coach {
    private final CoachName coachName;
    private IntolerantFood intolerantFood;
    private AlreadyEatenFood alreadyEatenFood;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
    }

    public void initIntolerantFood(IntolerantFood intolerantFood) {
        this.intolerantFood = intolerantFood;
    }

    public CoachName getCoachName() {
        return coachName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coach)) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(coachName, coach.coachName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachName);
    }
}
