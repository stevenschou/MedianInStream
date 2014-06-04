import java.util.*;

public class heap {

	private ArrayList<Integer> _heap;
	public HeapComparator comparator;
	
	public heap(HEAP_TYPE type) {
		_heap = new ArrayList<Integer>(); 
		comparator = HeapComparator.getHeapComparator(type);
	}
	
	public void addInteger(Integer i) {
		_heap.add(i);
		if(_heap.size() > 1) {
			heapifyUpFromLastNode();
		}
	}
	
	public void removeValue() {
		if(_heap.size() > 1) {
			Integer lastValue = _heap.get(_heap.size() - 1);
			_heap.set(0, lastValue);
			_heap.remove(_heap.size() - 1);
			heapifyFromRootDown();
		}
		else if (_heap.size() == 1){
			_heap.remove(0);
		}
		else {
			return;
		}
	}
	
	public Integer getValue() {
		if (_heap.size() > 0) {
			return _heap.get(0);
		} 
		else {
			return -1;
		}
	}
	
	private void heapifyFromRootDown() {
		Integer heapSize = _heap.size();
		Integer currentIndex = 0;
		
		while(currentIndex < _heap.size()) {
			Integer currentValue = _heap.get(currentIndex);
			Integer leftIndex = 2 * currentIndex + 1;
			if (leftIndex < heapSize) {
				Integer childIndex = leftIndex;
				Integer leftChildValue = _heap.get(leftIndex);
				Integer rightIndex = 2 * currentIndex + 2;
				if (rightIndex < heapSize) {
					Integer rightChildValue = _heap.get(rightIndex);
					if (comparator.compare(leftChildValue, rightChildValue) > 0) {
						childIndex = rightIndex;
					}
				}
				if (comparator.compare(leftChildValue, currentValue) < 0) {
					// swap
					_heap.set(currentIndex, _heap.get(childIndex));
					_heap.set(childIndex, currentValue);
				}
				else {
					return;
				}
				currentIndex = childIndex;
			}
			else {
				return;
			}
		}
	}
	
	private void heapifyUpFromLastNode() {
		int currentIndex = _heap.size() - 1;
		
		while(currentIndex >= 0) {
			int parentIndex = (currentIndex - 1) / 2;
			Integer parentValue = _heap.get(parentIndex);
			Integer currentValue = _heap.get(currentIndex);
			if(comparator.compare(currentValue, parentValue) < 0) {
				_heap.set(currentIndex, parentValue);
				_heap.set(parentIndex, currentValue);
			}
			else {
				return;
			}
			currentIndex = (currentIndex -1) / 2;
		}
	}
	
	public int getSize() {
		return _heap.size();
	}
	
	public void printHeap() {
		System.out.println("--- START HEAP ---");
		for(Integer i : _heap) {
			System.out.println(i);
		}
		System.out.println("--- END HEAP ---");
	}
}
