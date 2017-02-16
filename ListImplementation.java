package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@code ListImplementation} is a Linked List that wraps {@link Node}s and
 * provides useful operations.
 * 
 * @author jcollard
 * 
 */
public class ListImplementation<T> implements ListInterface<T>, Iterable<T> {
	
	private int size = 0;
	
	private Node<T> head;
	private Node<T> tail;
	
	public ListImplementation() {
	}

	/**
	 * Returns the number of nodes in this list.
	 */
	@Override
	public int size() {
        return size;
	}

	@Override
	public boolean isEmpty() {
        return head == null;
	}

	/**
	 * Appends {@code elem} to the end of this {@code ListImplementation} and
	 * returns itself for convenience.
	 */
	@Override
	public ListImplementation<T> append(T elem) {
		if(elem == null) throw new NullPointerException("Attempt to append null element to list");
		
		if(isEmpty()){
			head = new Node<T>(elem, null);
			tail = head;
		}
		else{
			tail.setNext(new Node<T>(elem, null));
			tail = tail.getNext();
		}
		size ++;
		return this;
	}

	/**
	 * Gets the {@code n}th element from this list.
	 */
	@Override
	public T get(int n) {
		if(n >= size) throw new NoSuchElementException("No element in index n");
		if(n < 0) throw new NoSuchElementException("index n cannot be negative");
		
		int count = 0;
		for(T elem : this){
			if(count == n)
				return elem;
			else{
				count ++;
			}
		}
		return null;
	}

	/**
	 * Returns an iterator over this list. The iterator does not support the
	 * {@code remove()} method.
	 */
	@Override
	public Iterator<T> iterator() {
        return new ListIterator<T>(head);
	}
}

