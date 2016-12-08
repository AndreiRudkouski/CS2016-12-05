package by.it.ededovich.lesson1;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить три способа вычисления чисел Фибоначчи.
 */
public class Fibo {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        int n = 33;
        System.out.printf("calc(%d)=%d \n\t time=%d \n\n", n, fibo.calc(n), fibo.time());

        //вычисление чисел фибоначчи медленным методом (рекурсией)
        fibo = new Fibo();
        n = 33;
        System.out.printf("slowA(%d)=%d \n\t time=%d \n\n", n, fibo.slowA(n), fibo.time());

        //вычисление чисел простым быстрым методом
        fibo = new Fibo();
        n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());

        //вычисление чисел фибоначчи самым быстрым методом
        fibo = new Fibo();
        n = 55555;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n), fibo.time());
    }


    private int calc(int n) {
        //здесь простейший вариант, в котором код совпадает с мат.определением чисел Фибоначчи
        //время O(2^n)
        if (n == 0)
            return 0;
        else
            if (n == 1)
                return 1;
        else
            return (calc(n-1)+calc(n-2));

    }


    BigInteger slowA(Integer n) {
        //рекурсия
        //здесь нужно реализовать вариант без ограничения на размер числа,
        //в котором код совпадает с мат.определением чисел Фибоначчи
        //время O(2^n)
       if (n==0)
            return BigInteger.ZERO;
        else if (n==1)
            return BigInteger.ONE;
        else
            return (slowA(n - 1).add(slowA(n - 2)));


       // return BigInteger.ZERO;
    }

    BigInteger fastB(Integer n) {

        BigInteger[] array = new BigInteger[n+1];

        array[0] = BigInteger.ZERO;
        array[1] = BigInteger.ONE;

        for (int i = 2; i < array.length; i++)
            array[i]=array[i-1].add(array[i-2]);

        return array[array.length-1];
        //return BigInteger.ZERO;
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)

    }

    BigInteger fasterC(Integer n) {

        //попробуйте здесь релизовать самый быстрый и эффективный по использованию памяти
        //вариант, какой только сумеете
        BigInteger[] array = new BigInteger[3];

        array[0] = BigInteger.ZERO;
        array[1] = BigInteger.ONE;

        for (int i = 0; i < n-1; i++){
            array[2] = array[1].add(array[0]);
            array[0] = array[1];
            array[1] = array[2];
        }

        return array[2];
        //return BigInteger.ZERO;
    }



}
