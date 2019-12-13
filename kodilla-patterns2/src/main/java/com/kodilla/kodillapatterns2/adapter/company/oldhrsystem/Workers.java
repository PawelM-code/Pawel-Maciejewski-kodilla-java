package com.kodilla.kodillapatterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"67032906720","John", "Smith"},
            {"62032906720","Ivone","Nowak"},
            {"75032906720","Jessie","Pinkman"},
            {"76032906720","Walter","White"},
            {"78032906720","Clara","Larson"}
    };
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00};
    public String getWorker(int n){
        if(n > salaries.length){
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
