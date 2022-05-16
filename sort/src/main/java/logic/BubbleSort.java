package logic;

import util.Converter;

/**
 * Class BubbleSort sort integer array method sorting Bubble sort
 * Calculation time execute sorting
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class BubbleSort{
    private double timeSort;    // variable store time execute sorting
    private long startTime;     // variable store start execute sorting
    private long endTime;       // variable store end execute sorting
    private String stepByStepSorting = "";

    public BubbleSort(){}

    /**
     * Sort arrive method Bubble sort and fix start, end execute sorting
     *
     * @param arr array for sorting
     * */
    public int[] sortArray(int[] arr) {
        int[] array = arr.clone();
        boolean flag;
        startTime = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            flag = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                    stepByStepSorting += "\n" + Converter.fromArrayToString(array);
                }
            }
            if (flag) {
                break;
            }
        }
        endTime = System.nanoTime();
        return array;
    }

    /**
     * Calculation speed sorting
     * Round value to seconds
     * */
    private void calculationSpeedSorting(){
        timeSort = (double)(endTime - startTime) / 1000000000;
    }

    /**
     * return time execute sorting
     * In the start call method for calculation speed sorting
     *
     * @return timeSort time sorting
     * */
    public double getTimeSort() {
        calculationSpeedSorting();
        return timeSort;
    }

    public String getStepByStepSorting() {
        return stepByStepSorting;
    }
}
