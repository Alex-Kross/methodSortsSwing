package logic;

import util.Converter;

/**
 * Class SelectSort sort integer array method sorting Select sort
 * Calculation time execute sorting
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class SelectSort{
    private double timeSort;    // variable store time execute sorting
    private long startTime;     // variable store start execute sorting
    private long endTime;       // variable store end execute sorting
    private String stepByStepSorting = "";

    public SelectSort(){}

    /**
     * Sort arrive method Select sort and fix start, end execute sorting
     *
     * @param arr array for sorting
     * */
    public int[] sortArray(int[] arr) {
        int[] array = arr.clone();
        int minEl, indexMinEl;
        startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            minEl = array[i];
            indexMinEl = i;
            for (int j = i; j < array.length - 1; j++) {
                if (minEl > array[j + 1]) {
                    minEl = array[j + 1];
                    indexMinEl = j + 1;
                }
            }
            int temp = array[i];
            array[i] = array[indexMinEl];
            array[indexMinEl] = temp;
            stepByStepSorting += "\n" + Converter.fromArrayToString(array);
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
