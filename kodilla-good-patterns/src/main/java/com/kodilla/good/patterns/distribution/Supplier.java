package com.kodilla.good.patterns.distribution;

class Supplier {
    private String name;
    private String mail;

    Supplier(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    String getName() {
        return name;
    }

    String getMail() {
        return mail;
    }
}
