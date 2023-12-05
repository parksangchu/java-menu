package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
        initIntolerantFoods(coachGroup);
        coachGroup.pickMenus();
    }

    private CoachGroup createCoachGroup() {
        while (true) {
            try {
                List<CoachName> coachNames = createCoachNames();
                return new CoachGroup(coachNames.stream()
                        .map(Coach::new)
                        .collect(Collectors.toList()));
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

    private void initIntolerantFoods(CoachGroup coachGroup) {
        coachGroup.getCoaches()
                .forEach(coach -> coach
                        .initIntolerantFood(createIntolerantFood(coach.getCoachName())));
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
