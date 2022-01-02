package pers.datastructure.list;

import java.util.Iterator;

public interface MyList<E> {

	/**
	 * 取得 List 長度
	 */
	int size();
	
	/**
	 * 將元素加到 List 尾端
	 */
	boolean add(E e);
	
	/**
	 * 取得指定索引的物件
	 * @param index
	 * @return
	 */
	E get(int index);
	
	/**
	 * 將指定元素插入某個索引中
	 * @param index
	 * @param e
	 * @return
	 */
	E set(int index, E e);
	
	/**
	 * 移除指定元素
	 * @param index
	 * @return
	 */
	E remove(int index);
	
	/**
	 * 此 List 長度是否為 0
	 */
	boolean isEmpty();
	
	/**
	 * 此 List 中是否包含某個物件
	 */
	boolean contains(Object o);
	
	/**
	 * 反轉 List
	 */
	public void reverse();
	
	/**
	 * 迭代物件
	 */
	Iterator<E> iterator();
}
