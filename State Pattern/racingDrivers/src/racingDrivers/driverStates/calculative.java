package racingDrivers.util;
import racingDrivers.util.Results;

public class calculative implements DriverStateInterface {

	/**
	 * @param object of ContextClass sets the state of the driver to the respective
	 *               state
	 * @return nothing
	 */
	public void doAction(ContextClass context, Results results) {
		// System.out.println("Driver is in the Calculative state");
		results.storeNewResult("CALCULATIVE");
		context.setState(this);
	}

	/**
	 * @param nothing returns the string i.e the state of the driver
	 * @return nothing
	 */
	public String toString() {
		return "CALCULATIVE";
	}

}