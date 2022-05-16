package util;

/**
 * Class FillArray fill array values
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class ArrayCreator {
    private final int MIN = 0;  // min value arrive
    private final int MAX;      // max value arrive

    /**
     * Constructors for instantiation maximum value arrive
     *
     * @param max max value array
     * */
    public ArrayCreator(int max) {
        MAX = max;
    }

    /**
     * Fill arrive random integer number in range(MIN,MAX)
     *
     * @param array array
     * */
    public void fillRandomNumber(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (MIN + Math.random() * (MAX - MIN + 1));
        }
    }
}
