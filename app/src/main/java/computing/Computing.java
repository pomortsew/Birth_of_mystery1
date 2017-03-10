
package computing;

import human.Human;

/**
 * Created by pomortsew on 30.01.17.
 */
public class Computing {


//    //Метод вычисляет число жизненого пути
////    public int careerNumber(Human human) throws IOException {
////        String tm;
////        int career = 0;//переменная в которую записывается число "Жизненный путь"
////
////        String tmp = human.getYearOfBirth() + human.getMonthOfBirth() + human.getBirthday();//слияние в одну строку годРождени + месяцРождения + деньРождения
////        char[] arrTmp = tmp.toCharArray();// разбиение строки на символы
////        int[] temp = new int[arrTmp.length];// временный массив для вычеслений
////        for (int i = 0; i < temp.length; i++) { // сложение всех чисел массива
////            tm = String.valueOf(arrTmp[i]);     //
////            temp[i] = Integer.parseInt(tm);     //
////            career = career + temp[i];
////        }
//////        if (career>=10&&career!=11&& career!=22){//сокращение числа "жизненный путь" до однозначного числа
//////            tm=String.valueOf(career);
//////
//////            arrTmp=tm.toCharArray();
//////            career=Integer.parseInt(String.valueOf(arrTmp[0]))+Integer.parseInt(String.valueOf(arrTmp[1]));
//////        }
//////
//////        if (career==11){
//////            File file= new File("data_file/foto.jpg");
//////            Desktop.getDesktop().open(file);
//////        }
////        return career;
////    }
//
//
//    //            метод сокращает многозначное число до однозначного числа кроме чисел 11 и 22 на вход принимает текст
//    public int reducingToSinglDigit(String txtNumber) {
//        int result = 0;
//        char[] arrayTemp = txtNumber.toCharArray();
//        if (Integer.valueOf(txtNumber) >= 10) {
//            for (int i = 0; i < arrayTemp.length; i++) {
//                result = result + Integer.valueOf(String.valueOf(arrayTemp[i]));
//            }
//            if (result >= 10 && result != 11 && result != 22) {
//                return reducingToSinglDigit(String.valueOf(result));
//            }
//        } else result = Integer.valueOf(String.valueOf(txtNumber));
//        return result;
//    }
//
//    //        перегрузка метода сокращающего многозначное число до однозначного числа кроме чисел 11 и 22 на вход принимает число
//    public int reducingToSinglDigit(int number) {
//        int result = 0;
//        char[] arrayTemp = String.valueOf(number).toCharArray();
//        if (number >= 10) {
//            for (int i = 0; i < arrayTemp.length; i++) {
//                result = result + Integer.valueOf(String.valueOf(arrayTemp[i]));
//            }
//            System.out.println(result);
//            if (result >= 10 && result != 11 && result != 22) {
//                return reducingToSinglDigit(result);
//            }
//        } else result = number;
//        return result;
//    }
//
//    // метод вычисляет число универсального года для возраста 27 лет
////    public int universalYearIn27Years(Human human) {
////        int AGE = 27;
////
////        int result = reducingToSinglDigit(human.getYearOfBirth() + AGE);
////        if (result == 11) {
////            result = 2;
////        } else if (result == 22) {
////            result = 4;
////        }
////        return result;
////    }
//
//    // метод вычисляет год начала продуктивного цикла
//    public int beginningOfTheProductiveCycle(UniversalNumber universalNumber, Human human) {
//        int result = 0;
//        int tmp = 0;
//
//        int personalYears = human.getYearOfBirth() + 27 + universalNumber.getDateOfBirth();
//
//        personalYears = reducingToSinglDigit(personalYears);
//
//        if (personalYears != 1 && personalYears >= 5) {
//
//            tmp = 10;
//            tmp = tmp - personalYears;
//            result = (human.getYearOfBirth() + 27) + tmp;
//
//        } else if (personalYears != 1 && personalYears <= 4) {
//
//            tmp = 1;
//            tmp = personalYears - tmp;
//            result = (human.getYearOfBirth() + 27) - tmp;
//
//
//        } else result = personalYears;
//
//        return result;
//    }
//
//    //    метод вычисляет год окончания продуктивного цикла
//    public int beginningOfTheProductiveCycle57(UniversalNumber universalNumber, Human human) {
//        int result = 0;
//        int tmp = 0;
//
//        int personalYears = human.getYearOfBirth() + 57 + universalNumber.getDateOfBirth();
//
//        personalYears = reducingToSinglDigit(personalYears);
//
//        if (personalYears != 1 && personalYears >= 5) {
//
//            tmp = 10;
//            tmp = tmp - personalYears;
//            result = (human.getYearOfBirth() + 27) + tmp;
//
//        } else if (personalYears != 1 && personalYears <= 4) {
//
//            tmp = 1;
//            tmp = personalYears - tmp;
//            result = (human.getYearOfBirth() + 57) - tmp;
//
//
//        } else result = personalYears;
//
//
//        return result;
//    }
//
//
//




}