package coding_Challenges;

public class Problem_10 {

	/*
	 * Implementation of binary Heap
	 * 
	 */
	
	BinaryHeap bh;
	
	public Problem_10() {
		bh = new BinaryHeap(11);
	}
	
	class BinaryHeap {
		int[] heap;
		int heapSize;
		
		public BinaryHeap(int size) {
			heapSize = -1;
			heap = new int[size];
			for (int i = 0; i < size; i++) {
				heap[i] = -1;
			}
		}
		
		public void printHeap() {
			for (int i : heap) {
				if ( i != -1 )System.out.println(i);
			}
		}
		
		public void insert(int elem) {
			
			if (heapSize + 1 == heap.length) {
				System.out.println("length of heap exceed");
				return;
			}
			
			
			heapSize += 1;
			heap[heapSize] = elem;
			
			siftUp();
		}
		
		public int remove() {
			
			if (heapSize - 1 < 0) {
				System.out.println("No element in heap");
				return -1;
			}
			int temp = heap[0];
			
			heap[0] = heap[heapSize];
			
			heap[heapSize] = -1;
			
			heapSize -= 1;
			siftDown();
			return temp;
			
		}
		
		public void siftUp() {
			
			int current = heapSize;
			
			while (current >= 1) {
				int parent = (current - 1) / 2;
								
				if (heap[parent] < heap[current]) {
					int temp = heap[parent];
					heap[parent] = heap[current];
					heap[current] = temp;
				} else {
					break;
				}
				current = parent;
			}
		}
		
		public void siftDown() {
			
			int current = 0;
			int limit = (heapSize - 1) / 2;
			int update;
			
			while (current <= limit) {
				
				int left 	= ( current * 2 ) + 1;
				int right 	= ( current * 2 ) + 2;
				
				int toCompare = heap[left] > heap[right] ? heap[left] : heap[right];
				
				if (heap[current] < toCompare) {
					if (toCompare == heap[left]) {
						int temp = heap[left];
						heap[left] = heap[current];
						heap[current] = temp;
						update = left;
					} else {
						int temp = heap[right];
						heap[right] = heap[current];
						heap[current] = temp;
						update = right;
					}
				} else {
					break;
				}
				current = update;
			}
		}
		
	}
	
	public static void main(String args[]) {
		Problem_10 p10 = new Problem_10();
		p10.bh.insert(10);
		p10.bh.insert(100);
		p10.bh.insert(15);
		p10.bh.insert(50);
		p10.bh.insert(30);
		p10.bh.insert(45);
		p10.bh.insert(40);
		p10.bh.printHeap();
		System.out.println("====");
		System.out.println(p10.bh.remove());
		System.out.println(p10.bh.remove());
		System.out.println(p10.bh.remove());
		System.out.println(p10.bh.remove());
		System.out.println(p10.bh.remove());
		System.out.println(p10.bh.remove());
	}
}
