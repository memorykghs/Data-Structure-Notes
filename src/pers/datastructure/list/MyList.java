package pers.datastructure.list;

import java.util.Iterator;

public interface MyList<E> {

	/**
	 * ���o List ����
	 */
	int size();
	
	/**
	 * �N�����[�� List ����
	 */
	boolean add(E e);
	
	/**
	 * ���o���w���ު�����
	 * @param index
	 * @return
	 */
	E get(int index);
	
	/**
	 * �N���w�������J�Y�ӯ��ޤ�
	 * @param index
	 * @param e
	 * @return
	 */
	E set(int index, E e);
	
	/**
	 * �������w����
	 * @param index
	 * @return
	 */
	E remove(int index);
	
	/**
	 * �� List ���׬O�_�� 0
	 */
	boolean isEmpty();
	
	/**
	 * �� List ���O�_�]�t�Y�Ӫ���
	 */
	boolean contains(Object o);
	
	/**
	 * ���� List
	 */
	public void reverse();
	
	/**
	 * ���N����
	 */
	Iterator<E> iterator();
}
