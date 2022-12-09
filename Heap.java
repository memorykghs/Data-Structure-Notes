package pers.datastructure.heap;

import java.util.Arrays;

public class Heap {
	/* 預設容量 */
	private int capacity = 10;

	/* 當前 array 的長度 */
	private int size = 0;

	/* 底層用 array 實現 */
	int[] items = new int[capacity];

	/* get left child index */
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	/* get right child index */
	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	/* get parent index */
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	/* 是否有 left child */
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	/* 是否有 right child */
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	/* 是否有 parent */
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	/* get left child value by parent index */
	private int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	/* get left child value by parent index */
	private int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	/* get parent value by child index */
	private int parent(int index) {
		return items[getParentIndex(index)];
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}

		return items[0];
	}

	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add (int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}
	
	public void heapifyUp() {
		int index = size - 1;
		// 當有 parent 且 parent 值大於當前節點
		while(hasParent(index) && parent(index) > items[index]) {
			swap(getParentIndex(index), index); // 交換
			index = getParentIndex(index); // 往上爬一層
		}
	}
	
	public void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			
			// 當左邊的值比右邊的大，當前最小 index 變成右節點
			if(hasRightChild(index) && rightChild(index) < leftChild(index)){
				smallerChildIndex = getRightChildIndex(index);
			}
			
			// 跟當前的節點 (父節點) 比較
			if(items[index] < items[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			
			index = smallerChildIndex;
		}
	}

	/* 交換 node value */
	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	/* 確保足夠的容量 */
	private void ensureExtraCapacity() {
		if (size == capacity) { // TODO size 哪裡賦值? (好像建立物件初期就在了)
			items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}
}
