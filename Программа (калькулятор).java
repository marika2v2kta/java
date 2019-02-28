/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{

static double function(double x, String func)
    {
        //заменяем х на полученное значение и убираем пробелы, чтобы не мешались
        func = func.replaceAll("x", String.valueOf(x));
        func = func.replaceAll(" ", "");
        System.out.println(func);

        //все возможные операции в формуле
        HashSet<Character> set = new HashSet<Character>();
        set.add('^');
        set.add('*');
        set.add('/');
        set.add('+');
        set.add('-');


        //выполняем по приоритету все возведения в степень
        while (func.contains("^"))
        {
            int pos = func.indexOf('^');
            String left = func.substring(0, pos);
            String right = func.substring(pos + 1, func.length());

            //выделяем левый аргумент
            int leftPos = left.length()-1;
            String leftArgument = "";
            while (leftPos >= 0 && !set.contains(left.charAt(leftPos))) {
                leftArgument = ((String.valueOf(left.charAt(leftPos))) + leftArgument);
                leftPos--;
            }

            //выделяем правый аргумент
            int rightPos = 0;
            String rightArgument = "";
            while (rightPos < right.length() && !set.contains(right.charAt(rightPos)))
                rightArgument = rightArgument  + (String.valueOf(right.charAt(rightPos++)));

            leftPos++;


            func = left.substring(0, (0>leftPos?0:leftPos)) + Math.pow(Double.parseDouble(leftArgument), Double.parseDouble(rightArgument)) + right.substring((rightPos<right.length()?rightPos:right.length()), right.length());
        }

        //проводим все умножения
        while (func.contains("*"))
        {
            int pos = func.indexOf('*');
            String left = func.substring(0, pos);
            String right = func.substring(pos + 1, func.length());

            //выделяем первый аргумент
            int leftPos = left.length()-1;
            String leftArgument = "";
            while (leftPos >= 0 && !set.contains(left.charAt(leftPos))) {
                leftArgument = ((String.valueOf(left.charAt(leftPos))) + leftArgument);
                leftPos--;
            }

            leftPos++;

            //выделяем правый аргумент
            int rightPos = 0;
            String rightArgument = "";
            while (rightPos < right.length() && !set.contains(right.charAt(rightPos)))
                rightArgument = rightArgument  + (String.valueOf(right.charAt(rightPos++)));

            //в запись формулы вместо возведения в степень пишем результат
            func = left.substring(0, (0>leftPos?0:leftPos)) + (Double.parseDouble(leftArgument)* Double.parseDouble(rightArgument)) + right.substring((rightPos<right.length()?rightPos:right.length()), right.length());
        }

        //проводим все деления
        while (func.contains("/"))
        {
            int pos = func.indexOf('/');
            String left = func.substring(0, pos);
            String right = func.substring(pos + 1, func.length());

            int leftPos = left.length()-1;
            String leftArgument = "";
            while (leftPos >= 0 && !set.contains(left.charAt(leftPos))) {
                leftArgument = ((String.valueOf(left.charAt(leftPos))) + leftArgument);
                leftPos--;
            }

            leftPos++;
            int rightPos = 0;
            String rightArgument = "";
            while (rightPos < right.length() && !set.contains(right.charAt(rightPos)))
                rightArgument = rightArgument  + (String.valueOf(right.charAt(rightPos++)));

            func = left.substring(0, (0>leftPos?0:leftPos)) + (Double.parseDouble(leftArgument)/ Double.parseDouble(rightArgument)) + right.substring((rightPos<right.length()?rightPos:right.length()), right.length());
        }

        //проводим все сложения
        while (func.contains("+"))
        {
            int pos = func.indexOf('+');
            String left = func.substring(0, pos);
            String right = func.substring(pos + 1, func.length());

            int leftPos = left.length()-1;
            String leftArgument = "";
            while (leftPos >= 0 && !set.contains(left.charAt(leftPos))) {
                leftArgument = ((String.valueOf(left.charAt(leftPos))) + leftArgument);
                leftPos--;
            }

            leftPos++;
            int rightPos = 0;
            String rightArgument = "";
            while (rightPos < right.length() && !set.contains(right.charAt(rightPos)))
                rightArgument = rightArgument  + (String.valueOf(right.charAt(rightPos++)));

            func = left.substring(0, (0>leftPos?0:leftPos)) +(Double.parseDouble(leftArgument) + Double.parseDouble(rightArgument)) + right.substring((rightPos<right.length()?rightPos:right.length()), right.length());
        }

        //проводим все вычитания
        while (func.contains("-"))
        {
            int pos = func.indexOf('-');
            String left = func.substring(0, pos);
            String right = func.substring(pos + 1, func.length());

            int leftPos = left.length()-1;
            String leftArgument = "";
            while (leftPos >= 0 && !set.contains(left.charAt(leftPos))) {
                leftArgument = ((String.valueOf(left.charAt(leftPos))) + leftArgument);
                leftPos--;
            }
            leftPos++;
            int rightPos = 0;
            String rightArgument = "";
            while (rightPos < right.length() && !set.contains(right.charAt(rightPos)))
                rightArgument = rightArgument  + (String.valueOf(right.charAt(rightPos++)));

            if (leftArgument.equals("")) leftArgument = "0";
            func = left.substring(0, (0>leftPos?0:leftPos)) + (Double.parseDouble(leftArgument)- Double.parseDouble(rightArgument)) + right.substring((rightPos<right.length()?rightPos:right.length()), right.length());

            try
            {
                return Double.parseDouble(func);
            }
            catch (NumberFormatException e)
            {}
        }
        return Double.parseDouble(func);
    }


	public static void main (String[] args) throws java.lang.Exception
	{
	double x;
	x=0;
	Scanner sc = new Scanner(System.in); 
	String   s = sc.next(); // "3+4*9^2-4/5"
	x=function(x, s); 
	System.out.println(x); 
	}
}