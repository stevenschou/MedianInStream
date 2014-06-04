import static org.junit.Assert.*;

import org.junit.Test;


public class medianReporterTest {

	@Test
	public void testMedianReporter() {
		medianReporter mr = new medianReporter();
		for(int i = 0; i < 10; i++) {
			mr.appendInteger(i);
		}
		assertEquals(mr.getMedian(), 4.5, 0.0000001);
		mr.appendInteger(20);
		assertEquals(mr.getMedian(), 5, 0.0000001);
	}

}
