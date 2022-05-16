package entity;

/**
 * Class Array contain sorted array integers number
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class SortedArray {
    // variable store sorted array
    private int[] sortedArray;

    /**
     * Constructors for instantiation SortedArray
     *
     * @param size size array
     * */
    public SortedArray(int size) {
        sortedArray = new int[size];
    }

    /**
     * Constructors for instantiation SortedArray
     *
     * @param sortedArray sorted array
     * */
    public SortedArray(int[] sortedArray) {
        this.sortedArray = sortedArray;
    }

    /**
     * set field sortedArray another sortedArray
     *
     * @param sortedArray sorted array
     * */
    public void setSortedArray(int[] sortedArray){
        this.sortedArray = sortedArray;
    }

    /**
     * return sorted array
     *
     * @return sortedArray
     * */
    public int[] getSortedArray(){
        return sortedArray;
    }

    /**
     * Convert field sortedArray into string
     *
     * @return String
     * */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < sortedArray.length; i++) {
            str += sortedArray[i] + " ";
        }
        return str;
    }
}
