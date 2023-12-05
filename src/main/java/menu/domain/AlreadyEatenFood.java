package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class AlreadyEatenFood {
    private final List<String> foods = new ArrayList<>();

    public void addFood(String food) {
        foods.add(food);
    }
}
