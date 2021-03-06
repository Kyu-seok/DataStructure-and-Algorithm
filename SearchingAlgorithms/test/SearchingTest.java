import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchingTest {

    static int arrNull[], arr0[], arr1[], arr10[];
    static Searching searching;

    @BeforeAll
    public static void init() {
        searching = new Searching();
        arrNull = null;
        arr0 = new int[0];
        arr1 = searching.generateSortedArrayWithoutMultipleOf5(1);
        arr10 = searching.generateSortedArrayWithoutMultipleOf5(10);
        System.out.println("Running a test...");
    }

    @Test
    public void linearSearchPrimePathCoverage() {
        assertThrows(IllegalArgumentException.class, () -> searching.linearSearch(arrNull, -1));    // t1
        assertEquals(-1, searching.linearSearch(arr0, 1));                                          // t2
        assertEquals(1, searching.linearSearch(arr10, 0));                                          // t3
        assertEquals(-1, searching.linearSearch(arr1, 1));                                          // t4
        assertEquals(3, searching.linearSearch(arr10, 2));                                          // t5
    }

    @Test
    public void linearSearchBaseChoiceCoverage() {
        assertEquals(2, searching.linearSearch(arr10, 1));                                          // t1
        assertThrows(IllegalArgumentException.class, () -> searching.linearSearch(arrNull, 1));     // t2
        assertEquals(-1, searching.linearSearch(arr0, 1));                                          // t3
        assertThrows(IllegalArgumentException.class, () -> searching.linearSearch(arr10, -1));      // t4
        assertEquals(1, searching.linearSearch(arr10, 0));                                          // t5
        assertEquals(-1, searching.linearSearch(arr10, 5));                                         // t6
    }

    @Test
    public void binarySearchPrimePathCoverage() {
        assertThrows(IllegalArgumentException.class, () -> searching.binarySearch(arr10, -1, false));   // t1
        assertEquals(-1, searching.binarySearch(arr0, 5, true));                                        // t2
        assertEquals(1, searching.binarySearch(arr1, 0, true));                                         // t3
        assertEquals(-1, searching.binarySearch(arr1, 1, true));                                        // t4
        assertEquals(-1, searching.binarySearch(arr10, 10, true));                                      // t5
        assertEquals(-1, searching.binarySearch(arr10, 5, true));                                       // t6
        assertEquals(3, searching.binarySearch(arr10, 2, true));                                        // t7
        assertEquals(3, searching.binarySearch(arr10, 0, true));                                        // t8
    }

    @Test
    public void binarySearchBaseChoiceCoverage() {
        assertEquals(2, searching.binarySearch(arr10, 1, true));                                        // t1
        assertThrows(Exception.class, () -> searching.binarySearch(arrNull, 1, true));                  // t2
        assertEquals(-1, searching.binarySearch(arr0, 1, true));                                        // t3
        assertThrows(IllegalArgumentException.class, () -> searching.binarySearch(arr10, -1, true));    // t4
        assertEquals(3, searching.binarySearch(arr10, 0, true));                                        // t5
        assertEquals(-1, searching.binarySearch(arr10, 5, true));                                       // t6
        assertThrows(IllegalArgumentException.class, () -> searching.binarySearch(arr10, 1, false));    // t7
    }

}