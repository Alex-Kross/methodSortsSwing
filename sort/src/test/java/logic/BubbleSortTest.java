package logic;

import org.junit.jupiter.api.Test;
import view.Printer;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sortArray() {
        int[] array = {-1,8,-3,4,6};
        int[] expected = {-1,-3,4,6,8};

        BubbleSort bubbleSort = new BubbleSort(new Printer());

        int[] actual = bubbleSort.sortArray(array);

        assertArrayEquals(expected,actual);
    }
}