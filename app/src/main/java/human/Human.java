
package human;

import computing.Computing;

/**
 * Created by pomortsew on 30.01.17.
 */
public class Human {

    Computing computing = new Computing();
    private final String name; //имя
    private final String surname;//фамилия
    private final String patronymic;//отчество
    private final int yearOfBirth;//год рождения
    private final int monthOfBirth;//месяц рождения
    private final int birthday;// день рождения



//      int formativeCycleNumber=computing.reducingToSinglDigit(getMonthOfBirth());//число формативного цикла, месяц рождения человека сокращенный до однозначного числа
//    private final int productiveCycleNumber;//число продуктивного цикла,  день рождения человека сокращенный до однозначного числа
//    private final int finalCycleNumber;//число финального цикла,  год рождения человека сокращенный до однозначного числа
//    private final int dataOfBirth;//число рождения, месяц рождения человека+ день рождения человека сокращенный до однозначного числа
//    private final int universalYearNumber;//число уневирсального года, год рождения человека  сокращенный до однозначного числа


    Human(HumanBuilder humanBuilder) {
        this.name = humanBuilder.getName();
        this.surname = humanBuilder.getSurname();

        this.patronymic = humanBuilder.getPatronymic();
        this.yearOfBirth = humanBuilder.getYearOfBirth();

        this.monthOfBirth = humanBuilder.getMonthOfBirth();
        this.birthday = humanBuilder.getBirthday();


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

}

