package by.it.alesnax.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance = new A_VideoRegistrator();
        double[] events = new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts = instance.calcStartTimes(events, 1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }

    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration) {
        //events - события которые нужно зарегистрировать
        //timeWorkDuration время работы видеокамеры после старта
        List<Double> result = null;
        result = new ArrayList<>();
        int i = 0;

        Arrays.sort(events);
        double currentStart;
        double currentEnd;
        while (i < events.length) {

            currentStart = events[i];
            result.add(currentStart);
            currentEnd = currentStart + workDuration;

            while (i < events.length) {
                if (events[i] <= currentEnd) {
                    i++;
                } else {
                    break;
                }

            }

        }
        System.out.println(result);
        return result;                        //вернем итог
    }
}
