package exercises.algos.questions;

import java.io.*;
import java.math.*;
import java.util.*;


    /*
     Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with  places after the decimal.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.

Example

There are  elements, two positive, two negative and one zero. Their ratios are ,  and . Results are printed as:

0.400000
0.400000
0.200000
Function Description

Complete the plusMinus function in the editor below.

plusMinus has the following parameter(s):

int arr[n]: an array of integers
Print
Print the ratios of positive, negative and zero values in the array. Each value should be printed on a separate line with  digits after the decimal. The function should not return a value.

Input Format

The first line contains an integer, , the size of the array.
The second line contains  space-separated integers that describe .

Constraints



Output Format

Print the following  lines, each to  decimals:

proportion of positive values
proportion of negative values
proportion of zeros
Sample Input

STDIN           Function
-----           --------
6               arr[] size n = 6
-4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
Sample Output

0.500000
0.333333
0.166667
Explanation

There are  positive numbers,  negative numbers, and  zero in the array.
The proportions of occurrence are positive: , negative:  and zeros: .
     */


public class CalculatePositiveNegativeZeroesRatios {

    public static void main(String[] args) throws IOException {
        List<Integer> arr = Arrays.asList(-4, 3, -9, 0, 4, 1);
        plusMinus(arr);
    }

    public static BigDecimal arraySize;

    public static void plusMinus(List<Integer> arr) {
        if (arr.size() <= 0 || arr.size() > 100) {
            System.out.println("Error: Input values are out of boundaries.");
            System.exit(1);
        }

        arraySize = BigDecimal.valueOf(arr.size());
        Collections.sort(arr);
        Integer amountOfPositivesNumbers = 0;
        Integer amountOfNegativeNumbers = 0;
        Integer amountOfZeroesNumbers = 0;

        for (Integer number : arr) {
            int category = Integer.compare(number, 0);
            switch (category) {
                case 1:
                    amountOfPositivesNumbers++;
                    break;
                case -1:
                    amountOfNegativeNumbers++;
                    break;
                case 0:
                    amountOfZeroesNumbers++;
                    break;
                default:
                    System.out.println("Unexpected value.");
            }
        }
        System.out.println(calculate(amountOfPositivesNumbers));
        System.out.println(calculate(amountOfNegativeNumbers));
        System.out.println(calculate(amountOfZeroesNumbers));
    }

    public static BigDecimal calculate(Integer i) {
        BigDecimal percentage = BigDecimal.valueOf(i).divide(arraySize, 6, RoundingMode.HALF_UP);

        return percentage;
    }

}
