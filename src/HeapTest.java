import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

	@Test
	public void addLots() {
		heap h = new heap(HEAP_TYPE.MAX_HEAP);
		for(int i = 0 ; i < 10; i++) {
			h.addInteger(i);
			h.printHeap();
		}
		assertEquals("the heap should have ten elements", h.getSize(), 10);
	}

}
