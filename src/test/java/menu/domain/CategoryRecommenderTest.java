package menu.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryRecommenderTest {

    @Test
    @DisplayName("일식을 이미 2번 이상 먹었다면, 다시는 일식을 추천하지 않는다.")
    void recommendCategories() {
        List<Coach> coaches = new ArrayList<>();
        Coach coach1 = new Coach(new CoachName("뭉이"));
        coach1.initExcludedMenu(new ExcludedMenu(List.of("")));
        Coach coach2 = new Coach(new CoachName("금실이"));
        coach2.initExcludedMenu(new ExcludedMenu(List.of("")));
        coaches.add(coach1);
        coaches.add(coach2);
        CoachGroup coachGroup = new CoachGroup(coaches);
        coach1.pickMenu(MenuCategory.JAPANESE);
        coach2.pickMenu(MenuCategory.JAPANESE);
        List<String> result = coach1.createRecommendResult();
        System.out.println(result);
        List<MenuCategory> menuCategories = CategoryRecommender.recommendCategories();
        for (MenuCategory menuCategory : menuCategories) {
            System.out.println(menuCategory.name());
        }
        assertThat(menuCategories.contains(MenuCategory.JAPANESE))
                .isFalse();
    }
}