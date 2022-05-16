package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {

    @Test
    void fromStringToArray() {
        int[] actual = new int[5];
        int[] expected = {2,3,6,-2,1};
        String arrayString = "2 3 6 -2 1 ";

        Converter.fromStringToArray(arrayString, actual);

        assertArrayEquals(expected,actual);
    }

    @Test
    void fromArrayToString() {
        int[] array = {2,3,6,-2,1};
        String expected = "2 3 6 -2 1 ";

        String actual = Converter.fromArrayToString(array);

        assertEquals(expected,actual);
    }

    @Test
    void culNumElsInString() {
        int expected = 5;
        String arrayString = "2 3 6 -2 1 ";

        int actual = Converter.CulNumElsInString(arrayString);

        assertEquals(expected,actual);
    }
}