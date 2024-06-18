package algorithms.alpha;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

interface NestedInteger{
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
    
 }
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList=null;
    Deque<List<NestedInteger>> stackObj= null;
    Deque<Integer> stackObjSize = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stackObj = new ArrayDeque<>();
        this.stackObjSize = new ArrayDeque<>();
        this.stackObj.offerLast(nestedList);
        this.stackObjSize.offerLast(0);
    }

    @Override
    public Integer next() { 
        int tempcount = this.stackObjSize.pollLast();
        int value = this.stackObj.peekLast().get(tempcount).getInteger();
        this.stackObjSize.offerLast(tempcount+1);
        return value;
    }

    @Override
    public boolean hasNext() {

        do{
            while(this.stackObj.size()>0 && this.stackObjSize.peekLast() == this.stackObj.peekLast().size()){
                this.stackObjSize.pollLast();
                this.stackObj.pollLast();
            }

            while(this.stackObj.size()>0 
                    && this.stackObjSize.peekLast()<this.stackObj.peekLast().size() 
                    && !this.stackObj.peekLast().get(this.stackObjSize.peekLast()).isInteger()){
                List<NestedInteger> tempObj = this.stackObj.peekLast().get(this.stackObjSize.peekLast()).getList();
                int count = this.stackObjSize.pollLast();
                this.stackObjSize.offerLast(count+1);
                this.stackObj.offerLast(tempObj);
                this.stackObjSize.offerLast(0);
            }
        }while(this.stackObj.size()>0 && this.stackObjSize.peekLast() == this.stackObj.peekLast().size());
  

        return this.stackObj.size()>0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */