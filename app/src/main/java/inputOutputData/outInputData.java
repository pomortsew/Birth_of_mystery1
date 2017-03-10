package inputOutputData;

import human.Cycles;
import human.Human;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by pomortsew on 30.01.17.
 */
public class outInputData {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String input(String txt) throws IOException {
        System.out.println(txt);
        String result = reader.readLine();
        return result;
    }

 public String out(Human human, Cycles cycles){
        String result="имя "+human.getName()
                +"\n"+"фамилия "+human.getSurname()
                +"\n"+"отчество "+human.getPatronymic()
                +"\n"+"год рождения "+human.getYearOfBirth()
                +"\n"+"месяц рождения "+human.getMonthOfBirth()
                +"\n"+"день рождения "+human.getBirthday()

                +"\n"+"число рождения  "+cycles.getDateOfBirth()
                +"\n"+"число формативного цикла "+cycles.getFormativeCycleNumber()
                +"\n"+"число продуктивного цикла "+cycles.getProducktiveCycleNumber()
                +"\n"+"число итогового цикла "+cycles.getFinalCycleNumber()

                +"\n"+"год начала продуктивного цикла "+cycles.getBeginningOfTheProductiveCycle()
                +"\n"+"год начала итогового цикла "+cycles.getBeginningOfTheFinalCycle()
                +"\n"+"число жизненого пути "+cycles.getNumberOfLifeJourney()
                +"\n"+"окончание  цикла достижений "+Arrays.toString(cycles.getAchievementsDuration())+"возраст окончания "
                +"\n"+"вибрирующие число цикла     "+Arrays.toString(cycles.getAchievementVibrationNumber())
                +"\n"+"жизненные отклики "+Arrays.toString(cycles.getVitalOff())
//                +"\n"+"день рождения "+human.getBirthday()
             ;

        return result;
 }

}
