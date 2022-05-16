package util;

/**
 * Class Converter work with arrive in string and vise versa
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class Converter {
    /**
     * Retrieve arrive from string and set it another array
     *
     * @param data string with array
     * @param array array which get array from data
     * */
    public static void fromStringToArray(String data, int[] array){
        for (int i = 0, index = 0; i < data.length(); i++, index++) {
            String el = "";
            while(data.charAt(i) != ' ') {
                el += String.valueOf(data.charAt(i));
                i++;
            }
            array[index] = Integer.valueOf(el);
        }
    }

    /**
     * Convert array to string
     *
     * @param array array which will convert be to string
     * @return str arrive in string
     * */
    public static String fromArrayToString(int[] array){
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i] + " ";
        }
        return str;
    }

    /**
     * Calculation number elements in arrive
     *
     * @param data string with array
     * */
    public static int CulNumElsInString(String data){
        int numberEls = 0;
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ' ') {
                numberEls++;
            }
        }
        return  numberEls;
    }
}
