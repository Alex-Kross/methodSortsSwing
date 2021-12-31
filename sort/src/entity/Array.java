package entity;

/**
 * Class Array contain array integers number
 *
 * @author Karpuk A.U.
 * @version 1.1 10.20.2021
 * */
public class Array {
    // variable store array
    private int[] array;

    /**
     * Constructors for instantiation Array
     *
     * @param size size array
     * */
    public Array(int size) {
        array = new int[size];
    }

    /**
     * set field array another array
     *
     * @param array array
     * */
    public void setArray(int[] array){
        this.array = array;
    }

    /**
     * return array
     *
     * @return array
     * */
    public int[] getArray(){
        return array;
    }

    /**
     * Convert field array into string
     *
     * @return String
     * */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < array.length; i++) {
            str += array[i] + " ";
        }
        return str;
    }
}
