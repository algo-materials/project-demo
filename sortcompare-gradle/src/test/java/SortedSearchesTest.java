import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortedSearchesTest {
    public Random rando = new Random();
    @Test
    public void testJumpSearchContains() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++)
            list.add(i);
        for (Integer i: list)
            assertTrue(SortedSearches.jumpSearch(list, i));
    }

    @Test
    public void testBinarySearchContains() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<10; i++)
            list.add(i);

        for (Integer i: list) {
            assertTrue(SortedSearches.binarySearch(list, i));
        }
    }

    @Test
    public void testJumpSearchNotContains() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++)
            list.add(i);
        for (Integer i: list)
            assertFalse(SortedSearches.jumpSearch(list, 10+i));
    }

    @Test
    public void testBinarySearchNotContains() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<10; i++)
            list.add(i);

        for (Integer i: list) {
            assertFalse(SortedSearches.binarySearch(list, 10+i));
        }
    }

    // -- random tests

    @Test
    public void testJumpSearchRandomContains() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++)
            list.add(rando.nextInt());
        // prereq: list must be sorted
        list.sort(Integer::compareTo);
        for (Integer i: list)
            assertTrue(SortedSearches.jumpSearch(list, i));
    }

    @Test
    public void testBinarySearchRandomContains() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++)
            list.add(rando.nextInt());
        // prereq: list must be sorted
        list.sort(Integer::compareTo);
        for (Integer i: list) {
            assertTrue(SortedSearches.binarySearch(list, i));
        }
    }

    @Test
    public void testJumpSearchRandomNotContains() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++)
            list.add((rando.nextInt()/2)*2);
        // prereq: list must be sorted
        list.sort(Integer::compareTo);
        // fun trick: only add even values, then search for odd values
        for (Integer i: list)
            assertFalse(SortedSearches.jumpSearch(list, 1+i));
    }

    @Test
    public void testBinarySearchRandomNotContains() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<10; i++)
            list.add((rando.nextInt()/2)*2);
        // prereq: list must be sorted
        list.sort(Integer::compareTo);
        for (Integer i: list) {
            assertFalse(SortedSearches.binarySearch(list, 1+i));
        }
    }
}