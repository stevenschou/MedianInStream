
public class medianReporter {

	private heap minHeap;
	private heap maxHeap;

	public medianReporter() {
		minHeap = new heap(HEAP_TYPE.MIN_HEAP);
		maxHeap = new heap(HEAP_TYPE.MAX_HEAP);
	}

	public void appendInteger(Integer i) {
		// we want to keep balance in the heaps
		int minHeapSize = minHeap.getSize();
		int maxHeapSize = maxHeap.getSize();

		if (maxHeapSize == 0 && minHeapSize == 0) {
			maxHeap.addInteger(i);
			return;
		}
		else if (minHeapSize == 0) {
			Integer maxHeapValue = maxHeap.getValue();
			if(maxHeapValue > i) {
				//swap
				minHeap.addInteger(maxHeap.getValue());
				maxHeap.removeValue();
				maxHeap.addInteger(i);
			}
			else {
				minHeap.addInteger(i);
			}
			return;
		}
		
		if (minHeapSize < maxHeapSize) {
			// try to add the element in the maxHeap
			if (minHeap.comparator.compare(minHeap.getValue(),i) < 0) {
				// it belongs in the min heap
				minHeap.addInteger(i);
			}
			else {
				// it belongs in the max heap
				minHeap.addInteger(maxHeap.getValue());
				maxHeap.removeValue();
				maxHeap.addInteger(i);
			}
		}
		else {
			// try to add the element in the maxHeap
			if (maxHeap.comparator.compare(maxHeap.getValue(),i) < 0) {
				// it belongs in the max heap
				maxHeap.addInteger(i);
			}
			else {
				// it belongs in the min heap
				maxHeap.addInteger(minHeap.getValue());
				minHeap.removeValue();
				minHeap.addInteger(i);
			}
		}
	}

	public double getMedian() {
		int minHeapSize = minHeap.getSize();
		int maxHeapSize = maxHeap.getSize();

		if(minHeapSize == maxHeapSize) {
			return (minHeap.getValue() + maxHeap.getValue()) / 2.;
		}
		else {
			return maxHeap.getValue();
		}	
	}

	public void printHeaps() {
		System.out.println("--- MAX HEAP --- ");
		maxHeap.printHeap();
		System.out.println();
		System.out.println("--- MIN HEAP --- ");
		minHeap.printHeap();
		System.out.println("----------------");
	}
}

