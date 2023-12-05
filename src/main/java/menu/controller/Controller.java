package menu.controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachGroup;
import menu.domain.CoachName;
import menu.domain.IntolerantFood;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void start() {
        OutputView.printStartNotice();
        CoachGroup coachGroup = createCoachGroup();
    }

    private CoachGroup createCoachGroup() {
        while (true) {
            try {
                List<Coach> coaches = new ArrayList<>();
                List<CoachName> coachNames = createCoachNames();
                for (CoachName coachName : coachNames) {
                    IntolerantFood intolerantFood = createIntolerantFood(coachName);
                    Coach coach = new Coach(coachName, intolerantFood);
                    coaches.add(coach);
                }
                return new CoachGroup(coaches);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private List<CoachName> createCoachNames() {
        while (true) {
            try {
                List<CoachName> coachNames = new ArrayList<>();
                List<String> names = InputView.readName();
                for (String name : names) {
                    coachNames.add(new CoachName(name));
                }
                return coachNames;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private IntolerantFood createIntolerantFood(CoachName coachName) {
        while (true) {
            try {
                List<String> foods = InputView.readIntolerantFood(coachName.getName());
                return new IntolerantFood(foods);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
