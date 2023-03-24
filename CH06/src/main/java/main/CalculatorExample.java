package main;

import chapter06.ExeTimeCalculator;
import chapter06.ImpleCalculator;
import chapter06.RecCalculator;

public class CalculatorExample {

    public static void main(String[] args) {
//        long num = 4;
//        long start1 = System.currentTimeMillis();
//        ImpleCalculator impleCalculator = new ImpleCalculator();
//        long result1 = impleCalculator.factorial(num);
//        long end1 = System.currentTimeMillis();
//        System.out.printf("ImpleCalculator.factorial(%d) 실행시간 = %d\n", num, (end1-start1));
//        System.out.printf("ImpleCalculator.factorial(4) 실행시간 = %d\n", result1);
//
//        long start2 = System.currentTimeMillis();
//        RecCalculator recCalculator = new RecCalculator();
//        long result2 = recCalculator.factorial(num);
//        long end2 = System.currentTimeMillis();
//        System.out.printf("RecCalculator.factorial(%d) 실행시간 = %d\n", num, (end2-start2));
//        System.out.printf("ImpleCalculator.factorial(4) 실행시간 = %d\n", result2);

        ExeTimeCalculator calculator1 = new ExeTimeCalculator(new ImpleCalculator());
        System.out.println(calculator1.factorial(20));

        ExeTimeCalculator calculator2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(calculator2.factorial(20));
    }
}