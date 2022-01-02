package pers.datastructure.list;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {

	/** 預設長度 */
	private static final int DEFAULT_CAPACITY = 10;

	private E[] array;

	public MyArrayList() {
		this.array = (E[]) new Object[DEFAULT_CAPACITY];

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}
}
