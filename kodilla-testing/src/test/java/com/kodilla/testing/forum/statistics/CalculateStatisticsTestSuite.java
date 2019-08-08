package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateStatisticsTestSuite{
    @Test
    public void  test1CalculateAdvStatistics(){
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testList = new ArrayList<>();
        for(int i =0;i<100;i++){
            testList.add("name");
        }
        int posts = 100;
        int comments = 1000;
        when(statisticsMock.usersNames()).thenReturn(testList);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);

        double[] averageArray = calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(1, averageArray[0],0.01); //averagePostsQuantity
        Assert.assertEquals(10, averageArray[1],0.01); //averageCommentsQuantity
        Assert.assertEquals(10, averageArray[2],0.01); //averagePostCommentQuantity
    }
    @Test(expected=java.lang.ArithmeticException.class)
    public void  test2CalculateAdvStatistics(){
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testList = new ArrayList<>();
        for(int i =0;i<0;i++){
            testList.add("name");
        }
        int posts = 0;
        int comments = 0;
        when(statisticsMock.usersNames()).thenReturn(testList);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);

        double[] averageArray = calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(0, averageArray[0],0.01); //averagePostsQuantity
        Assert.assertEquals(0, averageArray[1],0.01); //averageCommentsQuantity
        Assert.assertEquals(0, averageArray[2],0.01); //averagePostCommentQuantity
    }
    @Test
    public void  test3CalculateAdvStatistics(){
        Statistics statisticsMock = mock(Statistics.class);
        List<String> testList = new ArrayList<>();
        for(int i =0;i<100;i++){
            testList.add("name");
        }
        int posts = 10000;
        int comments = 1000;
        when(statisticsMock.usersNames()).thenReturn(testList);
        when(statisticsMock.postsCount()).thenReturn(posts);
        when(statisticsMock.commentsCount()).thenReturn(comments);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);

        double[] averageArray = calculateStatistics.calculateAdvStatistics(statisticsMock);

        Assert.assertEquals(100, averageArray[0],0.1); //averagePostsQuantity
        Assert.assertEquals(10, averageArray[1],0.1); //averageCommentsQuantity
        Assert.assertEquals(0.1, averageArray[2],0.1); //averagePostCommentQuantity
    }
}