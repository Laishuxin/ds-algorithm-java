package Array;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Project  ds-algorithm-java
 * File     JUnit5 Test Class.java.java
 *
 * @author LaiShuXin
 * @time 2021-08-27 7:00
 */
class ArrayTest {

    private Array<Integer> iArr1;
    private Array<Integer> iArr2;
    private Array<Integer> iArr3;
    private Array<Integer> iArr4;
    private Array<Integer> iArr5;
    private Array<Integer> iArr6;
    private Array<Integer> iArr7;
    private Array<Integer> iArr8;

    private void fill(Array<Integer> arr) {
        for (int i = 0; i < arr.capacity(); i++) {
            arr.addLast(i);
        }
    }

    @BeforeEach
    void setUp() {
        iArr1 = new Array();
        iArr2 = new Array(1);
        iArr3 = new Array(2);
        iArr4 = new Array(10);

        iArr5 = new Array();
        iArr6 = new Array(1);
        iArr7 = new Array(2);
        iArr8 = new Array(10);
        fill(iArr5);
        fill(iArr6);
        fill(iArr7);
        fill(iArr8);
    }

    @Test
    void capacity() {
        assertEquals(8, iArr1.capacity());
        assertEquals(1, iArr2.capacity());
        assertEquals(2, iArr3.capacity());
        assertEquals(10, iArr4.capacity());
        assertEquals(8, iArr5.capacity());
        assertEquals(1, iArr6.capacity());
        assertEquals(2, iArr7.capacity());
        assertEquals(10, iArr8.capacity());

        iArr5.addLast(1);
        assertEquals(16, iArr5.capacity());
        iArr6.addLast(1);
        assertEquals(2, iArr6.capacity());
        iArr7.addLast(1);
        assertEquals(4, iArr7.capacity());
        iArr8.addLast(1);
        assertEquals(20, iArr8.capacity());
    }

    @Test
    void size() {
        assertEquals(iArr1.size(), 0);
        iArr1.addFirst(1);
        assertEquals(iArr1.size(), 1);
        iArr1.addFirst(2);
        assertEquals(iArr1.size(), 2);
        iArr1.removeFirst();
        assertEquals(iArr1.size(), 1);
    }

    @Test
    void get() {
        assertEquals(0, iArr5.get(0));
        assertEquals(1, iArr5.get(1));
        assertEquals(7, iArr5.get(7));
        assertEquals(null, iArr5.get(-1));
        assertEquals(null, iArr5.get(8));
    }

    @Test
    void find() {
        assertEquals(0, iArr5.find(0));
        assertEquals(1, iArr5.find(1));
        assertEquals(7, iArr5.find(7));
        assertEquals(-1, iArr5.find(8));
        assertEquals(-1, iArr5.find(10));
        assertEquals(-1, iArr5.find(10));
    }

    @Test
    void contains() {
        assertEquals(true, iArr5.contains(0));
        assertEquals(true, iArr5.contains(1));
        assertEquals(true, iArr5.contains(7));
        assertEquals(false, iArr5.contains(8));
    }

    @Test
    void set() {
        iArr5.set(0, 1);
        assertEquals(1, iArr5.get(0));
    }

    @Test
    void addLast() {
        iArr5.addLast(8);
        assertEquals(8, iArr5.get(8));
        assertEquals(7, iArr5.get(7));
        assertEquals(9, iArr5.size());
        assertEquals(16, iArr5.capacity());
        iArr5.addLast(9);
        assertEquals(8, iArr5.get(8));
        assertEquals(9, iArr5.get(9));
        assertEquals(10, iArr5.size());
        assertEquals(16, iArr5.capacity());
        iArr5.addLast(10);
        assertEquals(9, iArr5.get(9));
        assertEquals(10, iArr5.get(10));
        assertEquals(11, iArr5.size());
        assertEquals(16, iArr5.capacity());
    }

    @Test
    void addFirst() {
        iArr5.addFirst(-1);
        assertEquals(-1, iArr5.get(0));
        assertEquals(0, iArr5.get(1));
        assertEquals(7, iArr5.get(iArr5.size() - 1));
        assertEquals(16, iArr5.capacity());
    }

    @Test
    void add() {
        iArr5.add(4, 40);
        assertEquals(16, iArr5.capacity());
        assertEquals(40, iArr5.get(4));
        assertEquals(4, iArr5.get(5));
        assertEquals(3, iArr5.get(3));

        iArr5.add(5, 50);
        assertEquals(16, iArr5.capacity());
        assertEquals(40, iArr5.get(4));
        assertEquals(50, iArr5.get(5));
        assertEquals(4, iArr5.get(6));
    }

    @Test
    void removeLast() {
        Integer result;
        result = iArr5.removeLast();
        assertEquals(7, result);
        assertEquals(7, iArr5.size());
        assertEquals(8, iArr5.capacity());
        result = iArr5.removeLast();
        assertEquals(6, result);
        assertEquals(6, iArr5.size());
        assertEquals(8, iArr5.capacity());
        result = iArr5.removeLast();
        result = iArr5.removeLast();
        result = iArr5.removeLast();
        result = iArr5.removeLast();

        assertEquals(2, iArr5.size());
        assertEquals(4, iArr5.capacity());
    }

    @Test
    void removeFirst() {
        Integer result;
        result = iArr5.removeFirst();
        assertEquals(0, result);
        assertEquals(7, iArr5.size());
        assertEquals(8, iArr5.capacity());
        result = iArr5.removeFirst();
        assertEquals(1, result);
        assertEquals(6, iArr5.size());
        assertEquals(8, iArr5.capacity());
        result = iArr5.removeFirst();
        result = iArr5.removeFirst();
        result = iArr5.removeFirst();
        result = iArr5.removeFirst();

        assertEquals(2, iArr5.size());
        assertEquals(4, iArr5.capacity());
    }

    @Test
    void remove() {
        Integer result;
        result = iArr5.remove(1);
        assertEquals(1, result);
        assertEquals(0, iArr5.get(0));
        assertEquals(2, iArr5.get(1));
        assertEquals(7, iArr5.size());
        assertEquals(8, iArr5.capacity());

        result = iArr5.remove(1);
        assertEquals(2, result);
        assertEquals(0, iArr5.get(0));
        assertEquals(3, iArr5.get(1));

        result = iArr5.removeFirst();
        result = iArr5.removeFirst();
        result = iArr5.removeFirst();
        result = iArr5.removeFirst();

        assertEquals(2, iArr5.size());
        assertEquals(4, iArr5.capacity());
    }

    @Test
    void testToString() {
        int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        assertEquals(Arrays.toString(arr), iArr5.toString());
    }
}
