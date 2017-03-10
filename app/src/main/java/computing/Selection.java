package computing;

import android.app.Activity;
import android.content.res.Resources;

import com.example.pomortsew.birthofamystery.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import human.Cycles;

/**
 * Created by pomortsew on 02.03.17.
 */

public class Selection {
    //    Cycles cycles;
    // число формативного цикла месяц рождения сокращенный до однозначного числа
    int formativeCycleNumber;

    // число продуктивного цикла день рождения  сокращенный до однозначного числа
    int producktiveCycleNumber;

    // число итогового цикла год рождения  сокращенный до однозначного числа
    int finalCycleNumber;

    //    начало продуктивного цикла
    int beginningOfTheProductiveCycle;

    //    начало итогового цикла
    int beginningOfTheFinalCycle;

    // число универсального года год рождения  сокращенный до однозначного числа
    int universalYearNumber;

    // число рождения  день рождения+ месяц рождения сокращенный до однозначного числа
    int dateOfBirth;

// число персонального года ( число уневерсального года + число рождения )
//    private final int numberOfYearsPeronalnogo;

    // число жизненого пути
    int numberOfLifeJourney;

//    продолжительность вибраций достижений четыре числа которые означают окончание циклов достижения( вершины)
//    private int[] achievementsDuration;

// вибрирующие числа циклов достижения
//    private int[] achievementVibrationNumber;

    //    жызненные отклики
//    private int[] vitalOff;


    String[] allCycle;
    int[] numberCycleAchieving;
    int[] vitalOfCycle;
    int[] durationCycleAchieving; //продолжительность вершин
    int theBeginningOfTheProductiveCycle;
    int theBeginningOfTheFinalCycle;
    String []oterInfoArray;
    public Selection(Cycles cycles) {
        this.durationCycleAchieving = cycles.getAchievementsDuration();
        this.vitalOfCycle = cycles.getVitalOff();
        this.numberCycleAchieving = cycles.getAchievementVibrationNumber();
        this.theBeginningOfTheProductiveCycle = cycles.getBeginningOfTheProductiveCycle();             //    начало продуктивного цикла
        this.theBeginningOfTheFinalCycle = cycles.getBeginningOfTheFinalCycle();                        //    начало итогового цикла
        this.oterInfoArray=new String[]{
                " " ,
                " "+cycles.getNumberOfLifeJourney() ,
                " "  ,
                          " "+cycles.getBeginningOfTheProductiveCycle()  ,



        };
        this.allCycle = new String[]{

                "info_career",
                "career" + cycles.getNumberOfLifeJourney(),                   // число жизненого пути

                "info_formative_cycle",
                "formative_cycle" + cycles.getFormativeCycleNumber(),         // число формативного цикла месяц рождения сокращенный до однозначного числа

                "info_productive_cycle",
                "productive_cycle" + cycles.getProducktiveCycleNumber(),      // число продуктивного цикла день рождения  сокращенный до однозначного числа

                "info_final_cycle",
                "final_cycle" + cycles.getFinalCycleNumber(),                 // число итогового цикла год рождения  сокращенный до однозначного числа

                "info_beginning_productive_cycle",
                "beginning_productive_cycle" + cycles.getBeginningOfTheProductiveCycle(),                   //    начало продуктивного цикла

                "info_beginning_final_cycle",
                "beginning_final_cycle" + cycles.getBeginningOfTheFinalCycle(),                        //    начало итогового цикла

                "info_universal_year_number",
                "universal_year_number" + cycles.getUniversalYearNumber(),                             // число универсального года год рождения  сокращенный до однозначного числа

                "info_date_of_birth",
                "date_of_birth" + cycles.getDateOfBirth(),                                     // число рождения  день рождения+ месяц рождения сокращенный до однозначного числа


                "info_achieving_the_number_cycle",
//                "Ваш первый цикл начинается со дня роджения и длитьтся до "+durationCycleAchieving[0]+"лет",
                "achieving_the_number_cycle" + this.numberCycleAchieving[0],           //вибрирующее число 1 цикла достижения
//                "Ваш второй цикл начинается со дня роджения и длитьтся до "+durationCycleAchieving[1]+"лет",
                "achieving_the_number_cycle" + this.numberCycleAchieving[1],           //вибрирующее число 2 цикла достижения
//                "Ваш третий цикл начинается со дня роджения и длитьтся до "+durationCycleAchieving[2]+"лет",
                "achieving_the_number_cycle" + this.numberCycleAchieving[2],           //вибрирующее число 3 цикла достижения
//                "Ваш четвертый цикл начинается со дня роджения и длитьтся до "+durationCycleAchieving[3]+"лет",
                "achieving_the_number_cycle" + this.numberCycleAchieving[3],           //вибрирующее число 4 цикла достижения
                "info_vital_of",
                "vital_off_1" + this.vitalOfCycle[0],
                "vital_off_2" + this.vitalOfCycle[1],
                "vital_off_3" + this.vitalOfCycle[2],


        };
    }

    public String constructorInformation(Activity activity1) {
        String result = "";
        String temp = "";
        Resources resources = activity1.getResources();
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        BufferedReader bfrOthirInfo = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.otherinfo)));

        for (int i = 0; i < allCycle.length; i++) {
            BufferedReader bfrAllInfo = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.allinfo)));
            try {
                while ((temp = bfrAllInfo.readLine()) != null) {

                    if (temp.equals(allCycle[i])) {

                        while (!(temp = bfrAllInfo.readLine()).equals("end")) {

                            stringBuilder.append(temp + "\n");
                        }
                        temp = bfrOthirInfo.readLine();
                        temp += bfrOthirInfo.readLine();
                        stringBuilder.append("\n" + temp + "\n");
                    }
                }
                bfrAllInfo.close();

            } catch (Exception e) {
            }

        }
        result = stringBuilder.toString();
        return result;
    }
}
