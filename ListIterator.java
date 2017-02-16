package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<T> implements Iterator<T> {

	private Node<T> cur;
	
	public ListIterator(Node<T> head){
		cur = head;
	}
	
	@Override
	public boolean hasNext(){
		return cur != null; 
	}
	
	@Override
	public T next(){
		if(cur == null) throw new NoSuchElementException("null node in iterator");
		
		T ret = cur.getData();
		cur = cur.getNext();
		return ret;
	}
	
}
