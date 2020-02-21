package racingDrivers.util;
import racingDrivers.util.Results;

public class reckless implements DriverStateInterface {

	/**
	 * @param object of ContextClass sets the state of the driver to the respective
	 *               state
	 * @return nothing
	 */
	public void doAction(ContextClass context, Results results) {
		// System.out.println("Driver is in the Reckless state");
		results.storeNewResult("RECKLESS");
		context.setState(this);
	}

	/**
	 * @param nothing returns the string i.e the state of the driver
	 * @return nothing
	 */
	public String toString() {
		return "RECKLESS";
	}
}
