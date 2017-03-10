package computing;

import android.app.Activity;
import android.content.res.Resources;
import com.example.pomortsew.birthofamystery.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import human.Cycles;


public class ConstruclionInformation {
    String[] nameCycleNumber;
    String[] numberCycle;

    public ConstruclionInformation(Cycles cycles) {
        int[] vitallOfConstruction=cycles.getVitalOff();

        int[] durationCycleAchieving = cycles.getAchievementsDuration();
        int[] achievements = cycles.getAchievementVibrationNumber();
        this.numberCycle = new String[]{
                " " + cycles.getNumberOfLifeJourney(),               //число жизненого пути
                " ",                                                 //Начало формативного цикла
                " " + cycles.getBeginningOfTheProductiveCycle(),     //Конец формативного цикла
                " " + cycles.getFormativeCycleNumber(),              //Число формативного цикла
                " " + cycles.getBeginningOfTheProductiveCycle(),     //нАЧАЛО ПРОДУКТИВНОГО ЦИКЛА
                " " + cycles.getBeginningOfTheFinalCycle(),          //Конец продуктивного цикла
                " " + cycles.getProducktiveCycleNumber(),            //Число продуктивнго цикла
                " " + cycles.getBeginningOfTheFinalCycle(),          //Начало Итогового цикла
                " ",                                                 //конец итогового цикла
                " " + cycles.getFinalCycleNumber(),                  //Число итогового цикла
                " ",                                                 //начало цикла первого достижения
                " " + durationCycleAchieving[0],                     //Конец первого цикла достижения (первая вершина)
                " " + achievements[0],                               //Число первого достижения
                " " + durationCycleAchieving[0],                     //Начало второго цикла достижения
                " " + durationCycleAchieving[1],                     //Конец второго цикла достижения (вторая вершина)
                " " + achievements[1],                               //Число второго достижения
                " " + durationCycleAchieving[1],                     //Начало третьего цикла достижения
                " " + durationCycleAchieving[2],                     //Конец третьего цикла достижения (третья вершина)
                " " + achievements[2],                               //Число третьего достижения
                " " + durationCycleAchieving[2],                     //Начало четвертого цикла достижения
                " " + durationCycleAchieving[3],                     //Конец четвертого цикла достижения (четвертая вершина)
                " " + achievements[3],                               //Число четвертого достижения
                " " ,                                                //информация об откликах
                " " ,                                                //информация об откликах
                " " + vitallOfConstruction[0],                       //число пглавного отклика
                " " ,                                                //информация об откликах

                " " + vitallOfConstruction[1],                       //число перовго добавочного отклика
                " " ,                                                //информация об откликах
                " " + vitallOfConstruction[2],                       //число второго добавочного отклика

        };

        this.nameCycleNumber = new String[]{
                "info_career",                                                       //информация о цикле
                "career" + cycles.getNumberOfLifeJourney(),                          // число жизненого пути
                "info_formative_cycle",                                              //информация о цикле
                "formative_cycle" + cycles.getFormativeCycleNumber(),                //число формативного цикла
                "info_productive_cycle",                                             //информация о цикле
                "productive_cycle" + cycles.getProducktiveCycleNumber(),             //число продуктивного цикла
                "info_final_cycle",                                                  //информация о цикле
                "final_cycle" + cycles.getFinalCycleNumber(),                        //число итогового цикла
                "info_achieving_the_number_cycle",                                   //информация о цикле
                "achieving_the_number_cycle" + achievements[0],                      //число первого достижения
                "achieving_the_number_cycle" + achievements[1],                      //число второго достижения
                "achieving_the_number_cycle" + achievements[2],                      //число третьего достижения
                "achieving_the_number_cycle" + achievements[3],                      //число четвертого достижения
                "info_vitall_off",                                                    //информация об откликах
                "vitall_off_number"+vitallOfConstruction[0],                                 //число главного отклика
                "vitall_off_number"+vitallOfConstruction[1],                                 //число первого добавочного отклика
                "vitall_off_number"+vitallOfConstruction[2],                                 //число второго добавочного отклика

        };

    }


    public String OutInfo(Activity activity) {
        int index = 0;
        String result = "";
        String tmp = "";
        String tmp1 = "";
        Resources resources = activity.getResources();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader otherInfoBFR = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.otherinfo)));
        for (int i = 0; i < nameCycleNumber.length; i++) {
            BufferedReader allInfoBFR = new BufferedReader(new InputStreamReader(resources.openRawResource(R.raw.allinfo)));
            try {
                while (!(tmp = allInfoBFR.readLine()).equals(null)) {
                    if (tmp.equals(nameCycleNumber[i])) {
                        while (!(tmp = allInfoBFR.readLine()).equals("end")) {
                            stringBuilder.append(tmp + "\n");
                        }
                        stringBuilder.append("\n");
                        if ((tmp1 = allInfoBFR.readLine()).equals("completion")) {
                            while (!(tmp1 = otherInfoBFR.readLine()).equals("completion")) {
                                tmp1 += "  " + numberCycle[index] + " ";
                                stringBuilder.append(tmp1 + "\n");
                                index++;
                            }
                        }
                    }
                }
                allInfoBFR.close();
                otherInfoBFR.close();
            } catch (Exception e) {
            }
        }
        result = stringBuilder.toString();
        return result;
    }

}
