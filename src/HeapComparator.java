
enum HEAP_TYPE {
	MAX_HEAP,
	MIN_HEAP
}

public abstract class HeapComparator
{
	private HEAP_TYPE _type;

	protected HeapComparator(HEAP_TYPE type) {
		_type = type;
	}

	protected HEAP_TYPE getHeapType() {
		return _type;
	}

	public static HeapComparator getHeapComparator(HEAP_TYPE type) {
		final HeapComparator comparator;
		
		switch (type) {
		case MAX_HEAP:
			comparator = new MaxHeapComparator(type);
			break;
		case MIN_HEAP:
			comparator = new MinHeapComparator(type);
			break;
		default:
			throw new IllegalArgumentException(String.format(
                    "unknown heap type"));
		}
		
		return comparator;
	}

	public int compare(Integer i1, Integer i2) {
		return 0;
	}

	private static class MaxHeapComparator extends HeapComparator
	{
		protected MaxHeapComparator(HEAP_TYPE type) {
			super(type);
		}

		@Override
		public int compare(Integer i1, Integer i2) {
			return i2 - i1;
		}

	}

	private static class MinHeapComparator extends HeapComparator
	{
		protected MinHeapComparator(HEAP_TYPE type) {
			super(type);
		}

		@Override
		public int compare(Integer i1, Integer i2) {
			return i1 - i2;
		}

	}
}

