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
        addIgnoredMenu(coachGroup.Coaches());
        System.out.println(coachGroup.Coaches().get(0).getIgnoredMenu().getMenus().size());
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

    private void addIgnoredMenu(List<Coach> coaches) {
        while (true) {
            try {
                coaches.forEach(this::addIgnoredMenu);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private void addIgnoredMenu(Coach coach) {
        while (true) {
            try {
                List<String> ignoredMenu = InputView.readIgnoredMenu(coach.getName());
                ignoredMenu.stream()
                        .filter(menu -> !menu.isEmpty())
                        .forEach(coach::addIgnoredMenu);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
