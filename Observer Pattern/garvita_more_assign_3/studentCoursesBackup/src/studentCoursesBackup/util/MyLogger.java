
package studentCoursesBackup.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
      DEBUG_VALUE=2 [FIXME: add your own scheme here]
      DEBUG_VALUE=1 [FIXME: add your own scheme here]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, TREE,FROM_RESULTS, OBH, FILE, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	  switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  case 3: debugLevel = DebugLevel.FILE; break;
	  case 2: debugLevel = DebugLevel.OBH; break;
	  case 0: debugLevel = DebugLevel.RELEASE; break;
    case 1: debugLevel = DebugLevel.TREE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	  debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /**
	 * @return String
	 */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
