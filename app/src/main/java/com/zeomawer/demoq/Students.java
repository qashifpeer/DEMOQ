package com.zeomawer.demoq;

public class Students {

    private String name, father_name, mother_name, residence;

    public Students(String name, String father_name, String mother_name, String residence) {
        this.name = name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.residence = residence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }
}
