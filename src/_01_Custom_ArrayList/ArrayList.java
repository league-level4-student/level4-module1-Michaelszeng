package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList <T>{
	private T[] list;
	public ArrayList() {
		list = (T[]) new Object[0];
	}
	
	public T get(int loc) throws IndexOutOfBoundsException {
		T t = list[loc];
		return t;
	}
	
	public void add(T val) {
		T[] newList = (T[]) new Object[list.length+1];
		for (int i = 0; i<list.length; i++) {
			newList[i] = list[i];
		}
		newList[newList.length-1] = val;
		list = newList;
	}
	
	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		T[] newList = (T[]) new Object[list.length+1];
		for (int i = list.length-1; i>=loc; i--) {
			newList[i+1] = list[i];
		}
		newList[loc] = val;
		for (int i=0; i<loc; i++) {
			newList[i] = list[i];
		}
		list = newList;
	}
	
	public void set(int loc, T val) throws IndexOutOfBoundsException {
		list[loc] = val;
	}
	
	public void remove(int loc) throws IndexOutOfBoundsException {
		for (int i = loc; i<list.length-1; i++) {
			list[i] = list[i+1];
		}
		T[] newList = (T[]) new Object[list.length-1];
		for (int i=0; i<newList.length; i++) {
			newList[i] = list[i];
		}
		list = newList;
	}
	
	public boolean contains(T val) {
		for (T t : list) {
			if (t.equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return list.length;
	}
}