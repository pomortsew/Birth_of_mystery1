package human;

import computing.Computing;

/**
 * Created by pomortsew on 30.01.17.
 */
public class HumanBuilder {
    Computing computing = new Computing();
    private String name; //имя
    private String surname;//фамилия
    private String patronymic;//отчество
    private int yearOfBirth;//год рождения
    private int monthOfBirth;//месяц рождения
    private int birthday;// день рождения




    public HumanBuilder name(String name) {
        this.name = name;
        return this;
    }


    public HumanBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public HumanBuilder patronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public HumanBuilder yearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public HumanBuilder monthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
        return this;
    }

    public HumanBuilder birthday(int birthday) {
        this.birthday = birthday;
        return this;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getBirthday() {
        return birthday;
    }

    public Human bilid() {
        return new Human(this);
    }
}
