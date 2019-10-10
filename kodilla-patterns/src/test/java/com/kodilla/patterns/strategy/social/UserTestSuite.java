package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User ola = new Millenials("Ola Nowak");
        User jan = new YGeneration("Jan Kowalski");
        User janusz = new ZGeneration("Janusz Bąk");

        //When
        String olaSahrePost = ola.sharePost();
        System.out.println("Ola shared a post on: " + olaSahrePost);
        String janSharePost = jan.sharePost();
        System.out.println("Jan shared a post on: " + janSharePost);
        String januszSharePost = janusz.sharePost();
        System.out.println("Janusz shared a post on: " + januszSharePost);

        //Then
        Assert.assertEquals("Facebook", olaSahrePost);
        Assert.assertEquals("Twitter", janSharePost);
        Assert.assertEquals("Snapchat", januszSharePost);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User ola = new Millenials("Ola Nowak");

        //When
        String olaSahrePost = ola.sharePost();
        System.out.println("Ola shared a post on: " + olaSahrePost);
        ola.setSocialPublisher(new SnapchatPublisher());
        olaSahrePost = ola.sharePost();
        System.out.println("Ola shared a post on: " + olaSahrePost);

        //Then
        Assert.assertEquals("Snapchat", olaSahrePost);
    }
}
