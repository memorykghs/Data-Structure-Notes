package pers.datastructure.list;

public class MyNode<E> {
	private E e;
	
	private MyNode<E> next;
	
	public MyNode(E e) {
		this.e = e;
	}
	
	public E getData() {
		return e;
	}
	
	public MyNode<E> getNext() {
		return next;
	}
	
	public void setNext(MyNode<E> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return e.toString();
	}
}
