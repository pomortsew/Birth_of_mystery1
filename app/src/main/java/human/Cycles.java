package human;

import computing.Computing;

/**
 * Created by pomortsew on 04.02.17.
 */
public class Cycles {
    Computing computing = new Computing();

    //число формативного цикла месяц рождения сокращенный до однозначного числа
    private final int formativeCycleNumber;

    //число продуктивного цикла день рождения  сокращенный до однозначного числа
    private final int producktiveCycleNumber;

    //число итогового цикла год рождения  сокращенный до однозначного числа
    private final int finalCycleNumber;

    //    начало продуктивного цикла
    private final int beginningOfTheProductiveCycle;

    //    начало итогового цикла
    private final int beginningOfTheFinalCycle;

    //    продолжительность вибраций достижений четыре числа которые означают окончание циклов достижения( вершины)
    private int[] achievementsDuration;
    // вибрирующие числа циклов достижения
    private int[] achievementVibrationNumber;
    //    жызненные отклики
    private int[] vitalOff;


    //число универсального года год рождения  сокращенный до однозначного числа
    private final int universalYearNumber;

    //число рождения  день рождения+ месяц рождения сокращенный до однозначного числа
    private final int dateOfBirth;

    //число персонального года ( число уневерсального года + число рождения )
    private final int numberOfYearsPeronalnogo;

    //число жизненого пути
    private final int numberOfLifeJourney;


    public Cycles(Human human) {
        this.formativeCycleNumber = reducingToSinglDigit(human.getMonthOfBirth());
        this.producktiveCycleNumber = reducingToSinglDigit(human.getBirthday());
        this.finalCycleNumber = reducingToSinglDigit(human.getYearOfBirth());
        this.dateOfBirth = reducingToSinglDigit(human.getBirthday() + human.getMonthOfBirth());
        this.beginningOfTheProductiveCycle = beginningOfTheProductiveCycle(human);
        this.beginningOfTheFinalCycle = beginningOfTheFinalCycle57Years(human);
        this.achievementsDuration = durationOfVibrationAchievements();

        this.achievementVibrationNumber = calculationAchievementVibrationNumber(getFormativeCycleNumber(), getProducktiveCycleNumber(), getFinalCycleNumber());

        this.universalYearNumber = reducingToSinglDigit(human.getYearOfBirth());
        this.numberOfLifeJourney = reducingToSinglDigit(human.getBirthday() + human.getMonthOfBirth() + human.getYearOfBirth());
        this.numberOfYearsPeronalnogo = reducingToSinglDigit(getUniversalYearNumber() + getDateOfBirth());
        this.vitalOff = calculationVitalOff(/*getFormativeCycleNumber(), getProducktiveCycleNumber(), getFinalCycleNumber()*/);

    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public int[] getAchievementsDuration() {
        return achievementsDuration;
    }

    public int[] getAchievementVibrationNumber() {
        return achievementVibrationNumber;
    }

    public int getFormativeCycleNumber() {
        return formativeCycleNumber;
    }

    public int getProducktiveCycleNumber() {
        return producktiveCycleNumber;
    }

    public int getFinalCycleNumber() {
        return finalCycleNumber;
    }

    public int getBeginningOfTheProductiveCycle() {
        return beginningOfTheProductiveCycle;
    }

    public int getBeginningOfTheFinalCycle() {
        return beginningOfTheFinalCycle;
    }

    public int[] getVitalOff() {
        return vitalOff;
    }

    public int getUniversalYearNumber() {
        return universalYearNumber;
    }

    public int getNumberOfLifeJourney() {
        return numberOfLifeJourney;
    }

    //            перегрузка метода сокращающего многозначное число на вход принимает число
    private int reducingToSinglDigit(int number) {
        int result = 0;
        char[] arrayTemp = String.valueOf(number).toCharArray();
        if (number >= 10) {
            for (int i = 0; i < arrayTemp.length; i++) {
                result = result + Integer.valueOf(String.valueOf(arrayTemp[i]));
            }
            System.out.println(result);
            if (result >= 10 && result != 11 && result != 22) {
                return reducingToSinglDigit(result);
            }
        } else result = number;
        return result;
    }

    // метод вычисляет год начала продуктивного цикла
    private int beginningOfTheProductiveCycle(Human human) {
        int result = 0;
        int tmp = 0;
        int personalYears = human.getYearOfBirth() + 27 + getDateOfBirth();
        personalYears = reducingToSinglDigit(personalYears);
        if (personalYears != 1 && personalYears >= 5) {
            tmp = 10;
            tmp = tmp - personalYears;
            result = (human.getYearOfBirth() + 27) + tmp;
        } else if (personalYears != 1 && personalYears <= 4) {
            tmp = 1;
            tmp = personalYears - tmp;
            result = (human.getYearOfBirth() + 27) - tmp;
        } else result = personalYears;
        return result;
    }

    //    метод вычисляет год начала итогового цикла (окончания продуктивного цикла)
    private int beginningOfTheFinalCycle57Years(Human human) {
        int result = 0;
        int tmp = 0;
        int personalYears = human.getYearOfBirth() + 57 + getDateOfBirth();

        personalYears = reducingToSinglDigit(personalYears);
        if (personalYears != 1 && personalYears >= 5) {
            tmp = 10;
            tmp = tmp - personalYears;
            result = (human.getYearOfBirth() + 57) + tmp;
        } else if (personalYears != 1 && personalYears <= 4) {
            tmp = 1;
            tmp = personalYears - tmp;
            result = (human.getYearOfBirth() + 57) - tmp;
        } else result =(human.getYearOfBirth() + 57)+ personalYears;
        return result;
    }


    //метод вычисляет продолжительность циклов достижения определяет начало и конец четырех циклов
    private int[] durationOfVibrationAchievements() {
        int[] result = new int[4];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = 36 - getNumberOfLifeJourney();
            } else result[i] = result[i - 1] + 9;

        }
        return result;
    }


    // метод вычисляет вибрирующие числа циклов достижения
    public int[] calculationAchievementVibrationNumber(int month, int birthday, int year) {
        int[] result = new int[4];
        result[0] = reducingToSinglDigit(month + birthday);
        result[1] = reducingToSinglDigit(birthday + year);
        result[2] = reducingToSinglDigit(result[0] + result[1]);
        result[3] = reducingToSinglDigit(month + year);

        return result;
    }


    private int[] calculationVitalOff(/*int form1ativeCycle, int proddgetuctiveCycle, int finaglCycle*/) {
        int result[] = new int[3];

//        System.out.println("wbrks  " + getFormativeCycleNumber() + " " + getProducktiveCycleNumber() + " " + getFinalCycleNumber());


        if (getFormativeCycleNumber() > getProducktiveCycleNumber()) {
            result[0] = getFormativeCycleNumber() - getProducktiveCycleNumber();
        } else {
            result[0] = getProducktiveCycleNumber() - getFormativeCycleNumber();
//            System.out.println("aa");
        }


        if (getProducktiveCycleNumber() <= getFinalCycleNumber()) {
            result[1] = getFinalCycleNumber() - getProducktiveCycleNumber();

        } else {
            result[1] = getProducktiveCycleNumber() - getFinalCycleNumber();

        }


        if (result[0] <= result[1]) {
            result[2] = result[1] - result[0];

        } else {
            result[2] = result[0] - result[1];

        }
        /*for (int i = 0; i < result.length; i++) {
            if (result[i] > 10) {
                reducingToSinglDigit(result[i]);
            }
            System.out.println(result[i]);
        }*/

        return result;

    }
    //                метод сокращает многозначное число до однозначного числа на вход принимает текст
//   private int reducingToSinglDigit(String txtNumber) {
//        int result = 0;
//        char[] arrayTemp = txtNumber.toCharArray();
//        if (Integer.valueOf(txtNumber) >= 10) {
//
//            for (int i = 0; i < arrayTemp.length; i++) {
//                result = result + Integer.valueOf(String.valueOf(arrayTemp[i]));
//            }
//            if (result >= 10 && result != 11 && result != 22) {
//                return reducingToSinglDigit(String.valueOf(result));
//            }
//        } else result = Integer.valueOf(String.valueOf(txtNumber));
//        return result;
//    }
}
