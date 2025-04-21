package com.oguzhanozgokce.lab2104;

import java.util.Objects;

public class Footballer {
    private String id;
    private String name;
    private String team;
    private String country;
    private Integer age;
    private Integer score;

    public Footballer(String id, String name, String team, String country, Integer age, Integer score) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.country = country;
        this.age = age;
        this.score = score;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getCountry() { return country; }
    public int getAge() { return age; }
    public int getScore() { return score; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footballer that = (Footballer) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setScore(Integer score) {
        this.score = score;
    }
}
