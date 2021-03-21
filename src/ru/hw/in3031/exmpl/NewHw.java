package ru.hw.in3031.exmpl;


import java.util.Arrays;
import java.util.Scanner;


public class NewHw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        System.out.println(strConvertion(inputStr.toCharArray()));
    }

    public static String strConvertion(char[] inputStr) {
        String strToReturn = "";
        int numOfBrackets = 0;
        int indexOfFirstBracket = 0;
        int ratio = 0;
        for (int i = 0; i < inputStr.length; i++) {
            if (Character.isLetter(inputStr[i]) && numOfBrackets == 0)
                strToReturn += inputStr[i];
            if (Character.isDigit(inputStr[i]) && numOfBrackets == 0)
                ratio = Integer.parseInt(String.valueOf(inputStr[i]));
            if (inputStr[i] == '[') {
                numOfBrackets++;
                if (numOfBrackets == 1)
                    indexOfFirstBracket = i;
            }
            if (inputStr[i] == ']') {
                numOfBrackets--;
                if (numOfBrackets == 0) {
                    strToReturn += strConvertion(Arrays.copyOfRange(inputStr, indexOfFirstBracket + 1, i)).repeat(ratio);
                    indexOfFirstBracket = 0;
                    ratio = 0;
                }
            }
        }
        return strToReturn;
    }
}