package racingDrivers.util;


import java.util.List;
import java.lang.Math;
import racingDrivers.util.MyLogger;
import racingDrivers.util.MyLogger.DebugLevel;

import racingDrivers.util.DriverContextClass;
import racingDrivers.util.DriverContextInterface;
import racingDrivers.util.RaceContextClass;

public class ContextClass {

	private DriverStateInterface state;

	public ContextClass() {
		
		MyLogger.writeMessage ("Constructor"  ,
                                     DebugLevel.CONSTRUCTOR);
		state = null;
	}

	public void setState(DriverStateInterface state) {
		this.state = state;
	}

	public DriverStateInterface getState() {
		return state;
	}

}
