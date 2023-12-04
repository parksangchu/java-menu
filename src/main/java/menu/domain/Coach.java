package menu.domain;

public class Coach {
    private final CoachName coachName;
    private final IntolerantFood intolerantFood;
    private final AlreadyEatenFood alreadyEatenFood;

    public Coach(CoachName coachName, IntolerantFood intolerantFood, AlreadyEatenFood alreadyEatenFood) {
        this.coachName = coachName;
        this.intolerantFood = intolerantFood;
        this.alreadyEatenFood = alreadyEatenFood;
    }
}
