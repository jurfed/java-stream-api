package people;

import java.util.Objects;

public class People {
    public enum Sex {
        MAN, WOMEN
    }

    public String name;
    public Integer year;
    public Sex sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public People(String name, Integer year, Sex sex) {
        this.name = name;
        this.year = year;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", sex=" + sex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) &&
                Objects.equals(year, people.year) &&
                sex == people.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, sex);
    }
}

