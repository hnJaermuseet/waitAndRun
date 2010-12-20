
public class waitAndRun {

	/**
	 * Waits a given number of seconds and than runs a given program
	 * 
	 * @author Hallvard Nygard, hn@jaermuseet.no
	 * @see http://github.com/hnJaermuseet/waitAndRun
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length < 2)
		{
			System.out.println("Must give 2 arguments to use this program.\n" +
					"1: Seconds we should wait.\n" +
					"2: What we should execute"
					);
			System.exit(0);
		}
		
		int seconds = Integer.parseInt(args[0]);
		if(seconds < 0)
		{
			System.out.println("Seconds must be positive or 0.");
			System.exit(0);
		}
		
		try {
			// Waiting
			System.out.println("Waiting " + seconds +" seconds...");
			Thread.sleep(seconds * 1000);
			
			// Executing
			System.out.println("Executing "+args[1]);
			Process p = Runtime.getRuntime().exec(args[1]);
			p.waitFor();
			System.out.println(p.exitValue());
		}
		catch (Exception err) {
			err.printStackTrace();
		}
	}
}
