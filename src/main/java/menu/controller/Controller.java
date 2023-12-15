package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.CoachGroup;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void start() {
        CoachGroup coachGroup = createCoachGroup();
    }

    private CoachGroup createCoachGroup() {
        while (true) {
            try {
                List<String> coachNames = InputView.readCoachNames();
                List<Coach> coaches = coachNames.stream()
                        .map(Coach::new)
                        .collect(Collectors.toList());
                return new CoachGroup(coaches);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
