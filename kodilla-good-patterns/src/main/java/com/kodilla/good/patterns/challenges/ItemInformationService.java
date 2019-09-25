package com.kodilla.good.patterns.challenges;

public class ItemInformationService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Order confirmation for: " + user.getName() + " " + user.getSurname() + "\n");
    }
}
