package pers.datastructure.list;

import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {

	private MyNode<E> first;

	private MyNode<E> last;

	private int size;

	public E getFirst() {
		return first.getData();
	}

	public E getLast() {
		return last.getData();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(E e) {
		MyNode<E> node = new MyNode<E>(e);

		if (size == 0) { // �p�G�O�Ĥ@�Ӹ`�I
			first = node;

		} else { // �N��e�`�I�� pointer �u�V�U�@�Ӹ`�I
			last.setNext(node);
		}

		this.last = node; // �N�s�W���`�I�����̫�@�Ӹ`�I
		size++;
		return true;
	}

	@Override
	public E get(int index) {
		return getNode(index).getData();
	}

	@Override
	public E set(int index, E e) {
		
		MyNode<E> node = new MyNode<>(e);
		MyNode<E> previous = getNode(index - 1);
		MyNode<E> current = previous.getNext();
		previous.setNext(node);

		if (index == 0) {
			first = node;
		}

		while (index != 0) {
			current = current.getNext();
			index--;
		}

		node.setNext(current);
		previous.setNext(node);
		
		return e;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		MyNode<E> target = getNode(index);

		if (index == 0) {
			if (size == 1) {
				last = null;
			}
			first = first.getNext(); // ��V�쵲���A�u�ݱN�ĤG�� node ���w���Ĥ@��

		} else {
			// �N�e�@�Ӹ`�I�� pointer ���V next
			MyNode<E> previous = getNode(index - 1);
			MyNode<E> next = target.getNext();
			previous.setNext(next);

			if (index == size - 1) {
				this.last = previous;
			}
		}

		return target.getData();
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		MyNode<E> node = this.first;

		while (node != null) {
			sb.append(node.toString()).append(" ");
			node = node.getNext();
		}

		return sb.toString();
	}

	/**
	 * �q�Ĥ@�Ӹ`�I�M���A���o��e�`�I
	 * 
	 * @param index
	 * @return
	 */
	private MyNode<E> getNode(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}

		MyNode<E> current = first;

		for (int i = 0; i < index; i++) { // �]����m�H���A�����M���~����k���o��e���`�I
			current = current.getNext();
		}

		return current;
	}

	@Override
	public void reverse() {
		MyNode<E> previous = null;
		MyNode<E> current = this.first;
		MyNode<E> next;

		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}

		last = first;
		first = previous;
	}
}
