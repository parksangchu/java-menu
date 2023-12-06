package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.CategoryRecommender;
import menu.domain.Coach;
import menu.domain.CoachGroup;
import menu.domain.CoachName;
import menu.domain.ExcludedMenu;
import menu.domain.MenuCategory;
import menu.view.InputView;
import menu.view.OutputView;

public class Controller {
    public void start() {
        OutputView.printStartNotice();
        CoachGroup coachGroup = createCoachGroup();
        initExcludedFoods(coachGroup);
        List<MenuCategory> categories = CategoryRecommender.recommendCategories(coachGroup);
        coachGroup.pickMenu(categories);
        List<List<String>> recommendResult = coachGroup.createRecommendResult();
        OutputView.printResult(categories, recommendResult);
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

    private void initExcludedFoods(CoachGroup coachGroup) {
        coachGroup.getCoaches()
                .forEach(coach -> coach
                        .initExcludedMenu(createExcludedFood(coach.getCoachName())));
    }

    private ExcludedMenu createExcludedFood(CoachName coachName) {
        while (true) {
            try {
                List<String> foods = InputView.readExcludedFood(coachName.getName());
                return new ExcludedMenu(foods);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
