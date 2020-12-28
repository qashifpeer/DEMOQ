package com.zeomawer.demoq;

public class Students {

    private String std_name, father_name, mother_name, residence,Gender,dob,className,uid,phone;
    public Students(){}

    public Students(String std_name, String father_name, String mother_name, String residence,
                    String gender,String dob,String className,String uid,String phone) {
        this.std_name = std_name;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.residence = residence;
        this.Gender = gender;
        this.dob=dob;
        this.className=className;
        this.uid=uid;
        this.phone=phone;

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.Gender = gender;

    }

    public String getStd_name() {
        return std_name;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
