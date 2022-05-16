package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    void sortArray() {
        int[] array = {-1,8,-3,4,6};
        int[] expected = {-3,-1,4,6,8};
        BubbleSort bubbleSort = new BubbleSort();

        int[] actual = bubbleSort.sortArray(array);

        assertArrayEquals(expected,actual);
    }
}