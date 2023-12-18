package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendResultRepository {

    private static final List<RecommendResult> recommendResults = new ArrayList<>();

    public static List<RecommendResult> recommendResults() {
        return Collections.unmodifiableList(recommendResults);
    }

    public static void addRecommendResult(RecommendResult recommendResult) {
        recommendResults.add(recommendResult);
    }
}
