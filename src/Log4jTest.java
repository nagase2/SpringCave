import org.apache.log4j.Logger;
public class Log4jTest {

	// Define a static logger variable so that it references the
	// Logger instance named "MyApp".
	static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		System.out.println("java.lang.reflect.Method.invoke(Method.java:597)");
		// Set up a simple configuration that logs on the console.
		logger.info("Exiting application.");
		logger.info("Exiting application.");
	}
}
