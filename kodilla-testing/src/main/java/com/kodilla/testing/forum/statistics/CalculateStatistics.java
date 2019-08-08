package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;

public class CalculateStatistics {
    private Statistics statistics;

    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public double[] calculateAdvStatistics(Statistics statistics) {
        int usersCount = statistics.usersNames().size();
        int postsQuantity = statistics.postsCount();
        int commentsQuantity = statistics.commentsCount();
        double averagePostsQuantity = postsQuantity / usersCount;
        double averageCommentsQuantity = commentsQuantity / usersCount;
        double averagePostCommentQuantity = commentsQuantity / postsQuantity;
        return new double[]{averagePostsQuantity, averageCommentsQuantity, averagePostCommentQuantity};
    }
}
