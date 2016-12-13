package by.it.du4.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration){
        //events - события которые нужно зарегистрировать
        //timeWorkDuration время работы видеокамеры после старта
        List<Double> result = new ArrayList<>();
        int i=0;                              //i - это индекс события events[i]
        //комментарии от проверочного решения сохранены для подсказки, но вы можете их удалить.
        Arrays.sort(events);                  //подготовка к жадному поглощению массива событий
                                              //hint: сортировка Arrays.sort обеспечит скорость алгоритма
                                              //C*(n log n) + C1*n = O(n log n)


        //пока есть незарегистрированные события
        //получим одно событие по левому краю
        //и запомним время старта видеокамеры
        //вычислим момент окончания работы видеокамеры
        //и теперь пропустим все покрываемые события
        //за время до конца работы, увеличивая индекс

        double endOfTheEvent  = 0;

        while (i < events.length) {
            if (endOfTheEvent < events[i]) {
                result.add(events[i]);
                endOfTheEvent = events[i] + workDuration;
            }
            i++;
        }
        return result;                        //вернем итог
    }
}
