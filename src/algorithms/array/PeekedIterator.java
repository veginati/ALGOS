package algorithms.array;
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

/**
 * https://leetcode.com/problems/peeking-iterator/solution/
 */
public class PeekedIterator implements Iterator<Integer> {

    Iterator<Integer> iterator= null;
    Integer value = null;
    public PeekedIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator= iterator;

        if(iterator.hasNext())
            value = iterator.next();

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return value;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {

        Integer tempValue = value;
        if(iterator.hasNext())
            value = iterator.next();
        else
            value = null;
        return tempValue;
    }

    @Override
    public boolean hasNext() {
        return null!=value;
    }
}