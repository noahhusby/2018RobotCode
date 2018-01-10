**10** Import field data and Shuffleboard API from WPILib.
**20** Retrieve field data and robot starting location from field data API and Shuffleboard API, respectively.
**30** Switch case
	**IF** Position of robot on left side & switch ownership on left
		**THEN** Cross autonomous line and drop equipped cube on switch.
	**IF** Position of robot on right side & switch ownership on right:
		**THEN** Cross autonomous line and drop equipped cube on switch.
	**IF** Neither of the above (default case):
		**THEN** Attempt to cross autonomous line, doing nothing else.

---

*Roughly* equivalent to...

```java
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// class declaration here
String gameData;
gameData = DriverStation.getInstance().getGameSpecificMessage(); // 20
if(gameData.charAt(0) == "L" && SmartDashboard.getNumber("Position") == 1) { // 10 and 30
	// Cross autonomous line and do left side of switch.


} else if(gameData.charAt(0) == "R" && SmartDashboard.getNumber("Position") == 3) { // 10 and 30
	// Cross autonomous line and do right side of switch.


} else { // 10 and 30
	// Only attempt to cross autonomous line.
	for (int; number equivilent to power needed to cross line < x; int++){
	//move forward past the autonomous line
	}

}
```