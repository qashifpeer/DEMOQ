package com.zeomawer.demoq;

public class Students {

    private String std_name, father_name, mother_name, residence,Gender;
    public Students(){}

    public Students(String std_name, String father_name, String mother_name, String residence, String gender) {
        this.std_name = std_name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.residence = residence;
        this.Gender = gender;

    }

    public String getName() {
        return std_name;
    }

    public void setName(String name) {
        this.std_name = name;
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

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }
}
