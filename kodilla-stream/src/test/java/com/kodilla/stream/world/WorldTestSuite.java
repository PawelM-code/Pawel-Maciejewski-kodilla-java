package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        Country poland = new Country(new BigDecimal("38536869"));
        Country spain = new Country(new BigDecimal("40397842"));
        Country italy = new Country(new BigDecimal("58133509"));
        Country canada = new Country(new BigDecimal("35881659"));
        Country usa = new Country(new BigDecimal("329256465"));
        Country mexico = new Country(new BigDecimal("125959205"));
        Country japan = new Country(new BigDecimal("126168156"));
        Country china = new Country(new BigDecimal("1384688986"));
        Country indonesia  = new Country(new BigDecimal("262787403"));

        Continent europa = new Continent();
        europa.getCountryList().add(poland);
        europa.getCountryList().add(spain);
        europa.getCountryList().add(italy);

        Continent asia = new Continent();
        asia.getCountryList().add(japan);
        asia.getCountryList().add(china);
        asia.getCountryList().add(indonesia);


        Continent northAmerica = new Continent();
        northAmerica.getCountryList().add(canada);
        northAmerica.getCountryList().add(usa);
        northAmerica.getCountryList().add(mexico);

        World world = new World();
        world.addContinents(asia);
        world.addContinents(northAmerica);
        world.addContinents(europa);

        BigDecimal expectedResult = new BigDecimal("2401810094");
        Assert.assertEquals(expectedResult, world.getPeopleQuantity());
    }
}
