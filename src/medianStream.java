import java.io.*;

public class medianStream {

	public static void main(String args[]) {
		medianReporter mr = new medianReporter();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader( new InputStreamReader(System.in));
			Integer i = Integer.parseInt(br.readLine());
					
			while(i != -1) {
				mr.appendInteger(i);
				System.out.println("The median is now: " + mr.getMedian());
				i = Integer.parseInt(br.readLine());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(br != null) {
				try {
					br.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
