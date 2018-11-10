package com.dam.ebarbeito.pt13;


public class User {

    public static String USER_NAME = "username";
    public static String USER_GENDER = "gender"; // true -> male // false -> female
    public static String USER_SKILL_POINTS= "skillPoints";
    public static String name;
    public boolean gender;
    public static int skillPoints;

    public User(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
        this.skillPoints = 0;
    }

    public static String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public static int getSkillPoints() {
        return skillPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }
}
