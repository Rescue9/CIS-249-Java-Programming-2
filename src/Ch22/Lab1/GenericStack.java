package Ch22.Lab1;


public class GenericStack <E> {
	
	// allow for an expanded ArrayList, adding elements
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	
	// returns the size of the list
	public int getSize(){
		return list.size();
	}
	
	// process everything within the list
	public E peek(){
		return list.get(getSize() - 1);
	}
	
	// adds to the stack
	public void push (E o){
		list.add(o);
	}
	
	// removes the symbol from the stack
	public E pop(){
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}	
}
