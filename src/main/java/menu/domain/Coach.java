package menu.domain;

public class Coach {
    private final CoachName coachName;
    private final IntolerantFood intolerantFood;
    private AlreadyEatenFood alreadyEatenFood;

    public Coach(CoachName coachName, IntolerantFood intolerantFood) {
        this.coachName = coachName;
        this.intolerantFood = intolerantFood;
    }
}
