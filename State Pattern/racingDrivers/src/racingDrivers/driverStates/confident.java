package racingDrivers.util;
import racingDrivers.util.Results;

/**
 * @param object of ContextClass sets the state of the driver to the respective
 *               state
 * @return nothing
 */
public class confident implements DriverStateInterface {

	// Results results = new Results();

	public void doAction(ContextClass context, Results results) {
		// System.out.println("Driver is in the Confident state");
		results.storeNewResult("CONFIDENT");
		context.setState(this);
	}

	/**
	 * @param nothing returns the string i.e the state of the driver
	 * @return nothing
	 */
	public String toString() {
		return "CONFIDENT";
	}
}